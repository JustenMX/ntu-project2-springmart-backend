package com.springmart.springmartbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmart.springmartbackend.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
