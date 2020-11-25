package com.learn.org.springsecurityjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.org.springsecurityjpa.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String userName);

}
