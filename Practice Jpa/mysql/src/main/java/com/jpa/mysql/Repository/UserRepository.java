package com.jpa.mysql.Repository;

import com.jpa.mysql.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
