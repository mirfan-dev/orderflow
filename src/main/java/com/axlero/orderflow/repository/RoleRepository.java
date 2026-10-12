package com.axlero.orderflow.repository;

import com.axlero.orderflow.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,String> {

    Optional<Role> findFirstByRoleName(String roleName);
}