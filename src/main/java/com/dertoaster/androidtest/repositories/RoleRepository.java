package com.dertoaster.androidtest.repositories;

import com.dertoaster.androidtest.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
