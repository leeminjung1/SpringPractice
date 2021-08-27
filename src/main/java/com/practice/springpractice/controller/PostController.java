package com.practice.springpractice.controller;

import com.practice.springpractice.dto.PostRequest;
import com.practice.springpractice.entity.User;
import com.practice.springpractice.service.PostService;
import com.practice.springpractice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final UserService userService;

    @PostMapping("/newpost")
    public ResponseEntity newPost(@RequestBody PostRequest request) {
        log.info("title = {}, contents = {}, userId = {}", request.getPostTitle(), request.getPostContents(), request.getUserId());
        Optional<User> user = userService.getUserFromUserId(request.getUserId());
        if(postService.newPost(request, user.get()).equals("Success")) {
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity postLists() {
        return ResponseEntity.ok().body(postService.getAllPosts());
    }

    // partial update -> use HTTP PATCH.
    @PatchMapping("/{postId}")
    public ResponseEntity updatePost(@PathVariable Long postId, @RequestBody PostRequest request) {
        log.info("postId = {}", postId);
        log.info("update title = {}, update contents = {}", request.getPostTitle(), request.getPostContents());
        if(postService.updatePost(postId, request).equals("Success")) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity deletePost(@PathVariable("postId") Long postId) {
        if(postService.deletePost(postId).equals("Success")) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
