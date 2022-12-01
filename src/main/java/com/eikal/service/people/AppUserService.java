package com.eikal.service.people;

import com.eikal.models.people.AppUser;
import com.eikal.repository.people.AppUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public AppUser saveUser(AppUser appUser) {
        appUser.setDateCreated(LocalDateTime.now());
        appUser.setDateModified(LocalDateTime.now());
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return appUserRepository.save(appUser);
    }

    public AppUser getUserById(Long id) {
        return appUserRepository.findById(id).orElse(null);
    }

}
