package com.practice.springpractice.controller;

import com.practice.springpractice.dto.UserRequest;
import com.practice.springpractice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // sign up
    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody UserRequest request) {
        log.info("userId = {}, password = {}, userName = {}", request.getUserId(), request.getPassword(), request.getUserName());
        if(userService.signup(request).equals("Success")) {
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    // login
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserRequest request) {
        log.info("userId = {}, password = {}", request.getUserId(), request.getPassword());
        if(userService.login(request.getUserId(), request.getPassword()).equals("Success")) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    // update password
    @PatchMapping("/{userNum}")
    public ResponseEntity updatePassword(@PathVariable Long userNum, @RequestBody UserRequest request) {
        if(userService.updatePassword(userNum, request).equals("Success")) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    // delete user
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity deleteUser(@PathVariable String userId) {
        if(userService.deleteUser(userId).equals("Success")) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}