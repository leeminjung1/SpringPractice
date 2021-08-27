package com.practice.springpractice.dto;

// for list all posts

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostListResponse {
    private Long postNum;
    private String postTitle;
    private String postContents;
    private String userName;
}
