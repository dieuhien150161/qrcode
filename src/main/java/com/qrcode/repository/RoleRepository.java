package com.qrcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrcode.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);

}