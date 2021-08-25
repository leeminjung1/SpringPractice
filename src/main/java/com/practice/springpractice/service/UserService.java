package com.practice.springpractice.service;

import com.practice.springpractice.entity.User;
import com.practice.springpractice.dto.UserRequest;
import com.practice.springpractice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService{

    private final UserRepository userRepository;

    public String signup(UserRequest request){
        userRepository.save(User.builder()
                .userId(request.getUserId())
                .password(request.getPassword())
                .userName(request.getUserName())
                .build());
        return "Success";
    }
}