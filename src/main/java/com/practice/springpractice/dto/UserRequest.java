package com.practice.springpractice.dto;

import com.practice.springpractice.entity.Post;
import com.practice.springpractice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public final class UserRequest {
    private String userId;
    private String password;
    private String userName;

    public void updateEntity(User user) {
        user.setPassword(this.password);
    }

}