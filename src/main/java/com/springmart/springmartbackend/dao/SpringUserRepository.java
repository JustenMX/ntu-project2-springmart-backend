package com.springmart.springmartbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmart.springmartbackend.entity.SpringUser;

public interface SpringUserRepository extends JpaRepository<SpringUser, Long> {

}
