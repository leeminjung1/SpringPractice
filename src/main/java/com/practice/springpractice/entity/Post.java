package com.practice.springpractice.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor  // 파라미터가 없는 생성자를 생성
@AllArgsConstructor // class의 모든 field에 대한 생성자 생성
@Builder
@Getter
@Table
public class Post {

    @Id
    @GeneratedValue
    private long seq;

    @Setter
    @Column(nullable = false)
    private String postTitle;

    @Setter
    @Column(nullable = false)
    private String postContents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")    // FK
    private User user;
}
