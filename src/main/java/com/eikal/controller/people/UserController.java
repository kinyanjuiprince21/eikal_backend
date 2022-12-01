package com.eikal.controller.people;

import com.eikal.models.people.Relationship;
import com.eikal.models.people.User;
import com.eikal.service.people.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user/save")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        user = userService.saveUser(user);
        return user != null ?
                ResponseEntity.status(201).body(user) :
                ResponseEntity.status(415).build();
    }

    @GetMapping("user/{id}")
    public ResponseEntity<?> findUser(@PathVariable Long id) {
        User user = userService.findUser(id);
        return user != null ?
                ResponseEntity.status(200).body(user) :
                ResponseEntity.status(404).body("User not found");
    }

    @GetMapping("users")
    public ResponseEntity<?> findUsers(@RequestParam("page") int pageNo, @RequestParam("size") int pageSize) {
        Page<User> userPage = userService.findUsers(pageNo, pageSize);
        return !userPage.getContent().isEmpty() ?
                ResponseEntity.status(200).body(userPage) :
                ResponseEntity.status(415).body("no users found");
    }

    @PostMapping("relationship/save")
    public ResponseEntity<?> saveRs(@RequestBody Map<? extends String, Object> map) {
        Relationship relationship = userService.saveRs(map);
        return relationship != null ?
                ResponseEntity.status(201).body(relationship) :
                ResponseEntity.status(415).build();
    }

    @GetMapping("relationship/{id}")
    public ResponseEntity<?> findRelationship(@PathVariable Long id) {
        Relationship relationship = userService.findRelationship(id);
        return relationship != null ?
                ResponseEntity.status(200).body(relationship) :
                ResponseEntity.status(404).body("relationship not found");
    }

    @GetMapping("relationships/user")
    public ResponseEntity<?> findUserRelationships(@RequestParam("id") Long userId) {
        List<Relationship> relationships = userService.findUserRelationships(userId);
        return !relationships.isEmpty() ?
                ResponseEntity.status(200).body(relationships) :
                ResponseEntity.status(404).body("no user relationship was found");
    }

    @GetMapping("kins/user")
    public ResponseEntity<?> findAllUsersNextOfKin(@RequestParam("id") Long userId) {
        List<Relationship> nextOfKins = userService.findAllUsersNextOfKin(userId);
        return !nextOfKins.isEmpty() ?
                ResponseEntity.status(200).body(nextOfKins) :
                ResponseEntity.status(404).body("no user next of kin was found");
    }

}
