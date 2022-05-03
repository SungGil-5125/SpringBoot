package com.jpa.mysql.Repository;

import com.jpa.mysql.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
@Transactional
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        //dto써서 toEntity로 받기
        User user = User.builder()
                        .acount("Test User 03")
                        .email("sunggil0125@naver.com")
                        .phoneNumber("010-6546-6622")
                        .createAt(LocalDateTime.now())
                        .createdBy("admin")
                        .build();

        User newuser = userRepository.save(user);
        System.out.println("newuser = " + newuser);
    }
}