package com.eikal.repository.people;

import com.eikal.models.people.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
