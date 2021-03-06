package com.differenttaste.repository;

import com.differenttaste.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByNameAndPassword(String name, String password);
}
