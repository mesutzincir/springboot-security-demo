package com.testproject.repository;

import com.testproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {
    User findByEmail(String pemail);
}
