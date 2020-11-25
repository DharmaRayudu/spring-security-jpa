package com.learn.org.springsecurityjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.org.springsecurityjpa.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
