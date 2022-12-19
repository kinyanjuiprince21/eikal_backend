package com.eikal.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.eikal.models.organization.OrganizationAdmin;
import com.eikal.models.people.AppUser;
import com.eikal.models.people.UserRoles;
import com.eikal.service.organization.OrganizationAdminService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final OrganizationAdminService organizationAdminService;

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager, OrganizationAdminService organizationAdminService) {
        this.authenticationManager = authenticationManager;
        this.organizationAdminService = organizationAdminService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        try {
            return authenticationManager.authenticate(authenticationToken);
        } catch (Exception ex) {
            try {
                response.setHeader("status", "401");
                new ObjectMapper().writeValue(response.getOutputStream(), Map.of("Authentication Failed", ex.getMessage(), "status", "401"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        AppUser user = (AppUser) authentication.getPrincipal();
        Algorithm algorithm = Algorithm.HMAC256("eikal".getBytes());
        String accessToken = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + (30L * 24 * 60 * 60 * 1000)))
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);

        String refreshToken = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + (60L * 24 * 60 * 60 * 1000)))
                .withIssuer(request.getRequestURL().toString())
                .sign(algorithm);

        response.setHeader("access_token", accessToken);
        response.setHeader("refresh_token", refreshToken);
        Map<String, Object> tokens = new HashMap<>();

        if (user.getRole().equals(UserRoles.ORGANIZATION_SUPER_ADMIN) || user.getRole().equals(UserRoles.ORGANIZATION_ADMIN)) {
            OrganizationAdmin organizationAdmin = organizationAdminService.findByUser(user.getId());
            Map<String, Object> orgMap = new HashMap<>();
            orgMap.put("name", organizationAdmin.getOrganization().getName());
            orgMap.put("id", organizationAdmin.getOrganization().getId());
            orgMap.put("type", organizationAdmin.getOrganization().getType());
            tokens.put("organization", orgMap);
        }

        tokens.put("user", user);
        tokens.put("access_token", accessToken);
        tokens.put("refresh_token", refreshToken);
        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), tokens);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setHeader("status", "401");
        new ObjectMapper().writeValue(response.getOutputStream(), Map.of("Authentication Failed", failed.getMessage(), "status", "401"));
    }
}
