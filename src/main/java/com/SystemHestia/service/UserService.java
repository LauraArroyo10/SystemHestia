package com.SystemHestia.service;

import com.SystemHestia.model.User;
import com.SystemHestia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).get();
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public User updateUser(User user) {
        if (userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        }
        return null; // or throw an exception
    }
    public void deleteUser(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public User edit(User user) {
        if (userRepository.existsById(user.getId())) {
            User userBD = userRepository.findById(user.getId()).get();
            if (user.getName() != null) {
                userBD.setName(user.getName());
            }
            if (user.getEmail() != null) {
                userBD.setEmail(user.getEmail());
            }
            if(user.getPassword()!= null) {
                userBD.setPassword(user.getPassword());
            }
            //if(user.getRol()!= null) {
            //    userBD.setRol(user.getRol());
            //}
            return userRepository.save(userBD);
        }
        return null;
    }

}
