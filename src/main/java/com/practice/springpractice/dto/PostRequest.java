package com.practice.springpractice.dto;

import com.practice.springpractice.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostRequest {
    private String postTitle;
    private String postContents;
    private String userId;

    public void updateEntity(Post post) {
        post.setPostTitle(this.postTitle);
        post.setPostContents(this.postContents);
    }

}
