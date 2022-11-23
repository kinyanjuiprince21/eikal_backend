package com.eikal.models.people;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class AppUser extends Person implements UserDetails {

    @Id
    @SequenceGenerator(sequenceName = "app_user_sequence", name = "app_user_sequence", allocationSize = 1)
    @GeneratedValue(generator = "app_user_sequence", strategy = GenerationType.AUTO)
    private Long id;
    private String password;
    private boolean enabled;
    private boolean expired;
    private LocalDateTime lastLogin;

    @Enumerated(EnumType.STRING)
    private UserRoles role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.name()));
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
