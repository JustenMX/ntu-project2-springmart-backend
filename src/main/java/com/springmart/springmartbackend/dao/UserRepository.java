package com.springmart.springmartbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmart.springmartbackend.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
