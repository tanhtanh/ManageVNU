package com.example.registercourse.repository;

import com.example.registercourse.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByUsername(String username);

    @Query(value = "SELECT * From Users WHERE Users.role = 'STUDENT'",nativeQuery = true)
    List<Users> getAllStudent();

}
