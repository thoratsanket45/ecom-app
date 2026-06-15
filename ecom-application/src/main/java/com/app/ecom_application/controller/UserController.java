package com.app.ecom_application.controller;

//import org.apache.catalina.User;
import com.app.ecom_application.dto.UserRequest;
import com.app.ecom_application.dto.UserResponse;
import com.app.ecom_application.service.UserService;
import com.app.ecom_application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService ;

    // getting all user data
    @GetMapping("/api/users")
    public ResponseEntity<List<UserResponse>> getAllUsers() {

        return new ResponseEntity<>(userService.fetchAllUsers(), HttpStatus.OK);
    }
    @GetMapping("/api/users/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {

        return userService.fetchUser(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()) ;
    }
    // create new user
    @PostMapping ("/api/users")
    public ResponseEntity<String> createUser( @RequestBody UserRequest userRequest) {
        userService.addUser(userRequest);
        return ResponseEntity.ok("User created Successfully");
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id , @RequestBody UserRequest updateuserRequest) {
        boolean updated = userService.updateUser(id,updateuserRequest) ;
        if (updated) {
            return ResponseEntity.ok("User updated Successfully");
        }
        return ResponseEntity.notFound().build();

    }

}
