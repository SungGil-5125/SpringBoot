package com.jpa.mysql.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@ToString //toString()메소드 실행
@AllArgsConstructor //어노테이션이 붙은 모든 클래스의 모든 필드를 포함한 생성사를 생성한다.
@NoArgsConstructor //어노테이션이 붙은 클래스의 필드에 파라미터가 없는 생성자를 생성한다. /기본생성자
@Entity
@Builder //빌더 패턴을 사용할 수 있도록 빌더 api를 제공한다.
public class User {

    @Id //idex primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Primaty key의 전략
    private Long id;

    @Column(nullable = false)
    private String acount;

    private String email;

    private String phoneNumber;

    @Column(nullable = false)
    private LocalDateTime createAt;

    @Column(nullable = false)
    private String createdBy;

    private LocalDateTime updateAt;

    private String updateBy;

}
