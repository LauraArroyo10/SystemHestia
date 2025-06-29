package com.SystemHestia.controller;

import com.SystemHestia.dto.LoginDTO;
import com.SystemHestia.dto.UserDTO;
import com.SystemHestia.model.Role;
import com.SystemHestia.model.User;
import com.SystemHestia.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


//    @PostMapping
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        User createdUser = userService.createUser(user);
//        return ResponseEntity.status(201).body(createdUser);
//    }

    @PostMapping("/signUp")
    public ResponseEntity<User> createSignUpUser(@Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        User updatedUser = userService.updateUser(user);
        if (updatedUser != null) {
            return ResponseEntity.ok("usario actualizado");
        } else {
            return ResponseEntity.ok("Ups, ese usuario no ha podido ser encontrado");
        }
    }

    @PatchMapping
    public ResponseEntity<User> partialUpdateUser(@RequestBody User user) {
        User updatedUser = userService.edit(user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (userService.existsById(id)) {
            userService.deleteUser(id);
            return ResponseEntity.ok("Usuario eliminado");
        }
        return ResponseEntity.notFound().build();
    }



//login
//login guest
//login junior


}//class end


