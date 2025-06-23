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


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(201).body(createdUser);
    }

    @PostMapping("/signUp")
    public ResponseEntity<User> createSignUpUser(@Valid @RequestBody UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(Role.valueOf(userDTO.getRole()));
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(201).body(createdUser);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = userService.updateUser(user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
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
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }




    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        User user = userService.getUserByEmail(loginDTO.getEmail());

        if (user != null && user.getPassword().equals(loginDTO.getPassword())) {
            return ResponseEntity.ok(user); // O podés devolver solo algunos datos si querés más seguridad
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }

}

//@RestController
//@RequestMapping("/users")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    //GET ALL
//    @GetMapping
//    public ResponseEntity<?> getAllUsers() {
//        List <User> users = userService.getAllUsers();
//        if (users==null || users.isEmpty()){
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Collections.emptyList());
//        }
//        return ResponseEntity.ok(users);
//    }
//
//    //GET BY ID
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
//        if (userService.existsById(id)){
//            return ResponseEntity.ok(userService.getUserById(id));
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    //POST
//    @PostMapping
//    public ResponseEntity<?> createUser(@RequestBody User user) {
//        if (userService.existByName(user.getName())){
//            return ResponseEntity.status(HttpStatus.FOUND).body("El nombre "+user.getName()+" ya se encuentra registrado");
//        }
//        User createdUser = userService.createUser(user);
//        if (createdUser!=null){
//            return ResponseEntity.status(201).body(createdUser);
//        }
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hubo un problema para registrar");
//    }
//
////    @PostMapping("/signUp")
////    public ResponseEntity<User> createSignUpUser(@Valid @RequestBody UserDTO userDTO) {
////        User user = new User();
////        user.setName(userDTO.getName());
////        user.setEmail(userDTO.getEmail());
////        user.setPassword(userDTO.getPassword());
////        user.setRole(Role.valueOf(userDTO.getRole()));
////        User createdUser = userService.createUser(user);
////        return ResponseEntity.status(201).body(createdUser);
////    }
//
//    @PostMapping("/signUp")
//    public ResponseEntity<User> signUp(@Valid @RequestBody UserDTO userDTO) {
//        User createdUser = userService.createUser(new User());
//        return ResponseEntity.status(201).body(createdUser);
//    }
//
//    //PUT
//    @PutMapping
//    public ResponseEntity<User> updateUser(@RequestBody User user) {
//        User updatedUser = userService.updateUser(user);
//        if (updatedUser != null) {
//            return ResponseEntity.ok(updatedUser);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    //PATCH
//    @PatchMapping
//    public ResponseEntity<User> partialUpdateUser(@RequestBody User user) {
//        User updatedUser = userService.edit(user);
//        if (updatedUser != null) {
//            return ResponseEntity.ok(updatedUser);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    //DELETE
//    @DeleteMapping("{id}")
//    public ResponseEntity<?> delete(@PathVariable Integer id) {
//        if (userService.existsById(id)) {
//            userService.deleteUser(id);
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//}
