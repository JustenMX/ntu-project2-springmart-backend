package com.springmart.springmartbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmart.springmartbackend.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
