package com.SystemHestia.service;
import com.SystemHestia.dto.UserDTO;
import com.SystemHestia.model.Role;
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

    public User createUser(UserDTO userDTO) {
            User user = new User();
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setRole(Role.valueOf(userDTO.getRole()));
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
            if(user.getRole()!= null) {
                userBD.setRole(user.getRole());
            }
            return userRepository.save(userBD);
        }
        return null;
    }

    public boolean existByName(String name) {
        return userRepository.existsByName(name);
    }

    public boolean existsById(Integer id) {
        return userRepository.existsById(id);
    }






}
