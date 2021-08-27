package com.practice.springpractice.service;

import com.practice.springpractice.entity.User;
import com.practice.springpractice.dto.UserRequest;
import com.practice.springpractice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService{

    private final UserRepository userRepository;

    // signup
    public String signup(UserRequest request){
        userRepository.save(User.builder()
                .userId(request.getUserId())
                .password(request.getPassword())
                .userName(request.getUserName())
                .build());
        return "Success";
    }

    // login
    public String login(String userId, String password) {
        Optional<User> user = userRepository.findByUserId(userId);
        return user
                .map(m -> {
                    if(user.get().getPassword().equals(password)) {
                        return "Success";
                    }
                    return "Failed";
                })
                .orElseThrow(() -> new NoSuchElementException("Person not found"));
    }

    // Updating password
    public String updatePassword(Long userId, UserRequest request) {
        Optional<User> user = userRepository.findById(userId);
        request.updateEntity(user.get());
        userRepository.save(user.get());
        return "Success";
    }

    // delete account
    public String deleteUser(String userId) {
        Optional<User> user = userRepository.findByUserId(userId);
        userRepository.delete(user.get());
        return "Success";
    }

    public Optional<User> getUserFromUserId(String userId) {
        return userRepository.findByUserId(userId);
    }
}