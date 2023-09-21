package com.springmart.springmartbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmart.springmartbackend.entity.SpringUserAuth;

@Repository
public interface SpringUserAuthRepository extends JpaRepository<SpringUserAuth, Long> {

}
