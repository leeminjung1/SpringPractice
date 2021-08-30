package com.practice.springpractice.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor  // 파라미터가 없는 생성자를 생성
@AllArgsConstructor // class의 모든 field에 대한 생성자 생성
@Builder
@Setter
@Getter
@Table
public class Domain {

    @Id
    @GeneratedValue
    private Long id;

    private String fshlcNm;
    private String fshlcType;
    private String rdnmadr;
    private String lnmadr;
    private String latitude;
    private String longitude;
    private String fshlcPhoneNumber;
    private String waterAr;
    private String kdfsh;
    private String aceptncCo;
    private String wtrcFcltyType;
    private String useCharge;
    private String mainPoint;
    private String safentl;
    private String cvntl;
    private String cfrTrrsrt;
    private String phoneNumber;
    private String institutionNm;
    private String referenceDate;
    private String insttCode;

}
