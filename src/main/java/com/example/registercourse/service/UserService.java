package com.example.registercourse.service;

import com.example.registercourse.dto.UsersDto;
import com.example.registercourse.mapper.UserMapper;
import com.example.registercourse.models.Users;
import com.example.registercourse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UsersDto> getAllStudent() {
        return (List<UsersDto>) userRepository.getAllStudent().stream().map(users -> UserMapper.toUserDto(users));
    }

    public Users createUser(Users users) {
       return userRepository.save(users);
    }
    public UsersDto updateUser(Long id,UsersDto usersDetail) {
        UsersDto users = userRepository.findById(id).map(users1 -> UserMapper.toUserDto(users1))
                .orElseThrow(() -> new RuntimeException("No Student Found!"));
        users.setUsername(usersDetail.getUsername());
        users.setEmail(users.getEmail());
        return users;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
