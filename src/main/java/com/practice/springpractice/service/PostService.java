package com.practice.springpractice.service;

import com.practice.springpractice.dto.PostListResponse;
import com.practice.springpractice.dto.PostRequest;
import com.practice.springpractice.entity.Post;
import com.practice.springpractice.entity.User;
import com.practice.springpractice.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {
    private final PostRepository postRepository;

    // Publishing Post
    public String newPost(PostRequest request, User user) {
        postRepository.save(Post.builder()
                .postTitle(request.getPostTitle())
                .postContents(request.getPostContents())
                .user(user)
                .build()
        );
        return "Success";
    }

    // Show Posts
    public List<PostListResponse> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostListResponse> postListResponses = new ArrayList<>();

        for (Post p : posts) {
            PostListResponse post = new PostListResponse();
            post.setPostNum(p.getPostNum());
            post.setPostTitle(p.getPostTitle());
            post.setPostContents(p.getPostContents());
            post.setUserName(p.getUser().getUserName());
            postListResponses.add(post);
        }
        return postListResponses;
    }

    // Updating Posts
    public String updatePost(Long postNum, PostRequest request) {
        Optional<Post> post = postRepository.findById(postNum);
        request.updateEntity(post.get());
        postRepository.save(post.get());
        return "Success";
    }

    // Delete Posts
    public String deletePost(Long postNum) {
        Optional<Post> post = postRepository.findById(postNum);
        postRepository.delete(post.get());
        return "Success";
    }
}
