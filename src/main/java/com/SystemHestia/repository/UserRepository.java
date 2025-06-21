package com.SystemHestia.repository;

import com.SystemHestia.model.Patient;
import com.SystemHestia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    boolean existsByEmail(String email);
    User findByEmail(String email);
    boolean existsByName(String name );
    User findByName(String name);

}


