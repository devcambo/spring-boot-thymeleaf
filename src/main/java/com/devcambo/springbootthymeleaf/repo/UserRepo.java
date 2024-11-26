package com.devcambo.springbootthymeleaf.repo;

import com.devcambo.springbootthymeleaf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    User readByEmail(String email);

}
