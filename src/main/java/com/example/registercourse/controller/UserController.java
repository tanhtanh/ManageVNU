package com.example.registercourse.controller;

import com.example.registercourse.dto.UsersDto;
import com.example.registercourse.models.Users;
import com.example.registercourse.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/admin/students")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllStudent() {
        List<UsersDto> usersDto = userService.getAllStudent();
        return ResponseEntity.ok(usersDto);
    }
    @PostMapping("/admin/create")
    @PreAuthorize("hasRole('ADMIN')")
    public  ResponseEntity<?> createStudent(@RequestBody Users users) {
        Users result = userService.createUser(users);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/admin/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody UsersDto usersDto) {
        UsersDto result = userService.updateUser(id,usersDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/admin/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(null);
    }
}
