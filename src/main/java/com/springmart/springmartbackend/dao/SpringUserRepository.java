package com.springmart.springmartbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmart.springmartbackend.entity.SpringUser;

@Repository
public interface SpringUserRepository extends JpaRepository<SpringUser, Long> {

}
