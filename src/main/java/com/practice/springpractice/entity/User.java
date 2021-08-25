package com.practice.springpractice.entity;

import lombok.*;

import javax.persistence.*;

@Entity // JPA가 관리
@Table  // Specify a table to map
@Getter // getter/setter method 자동생성
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id             // PK
    @GeneratedValue // db에서 자동생성되는 값이라는 뜻~
    private long seq;

    @Column(unique = true)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userName;

}
