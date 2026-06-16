package com.example.app.service.repositories;

import com.example.app.model.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Long> {
    List<Users> findUsersByUserNameContains(String userName);
    Optional<Users> findByUserNameAndPassword(String userName, String password);

}
