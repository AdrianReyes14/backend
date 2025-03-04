package com.example.demo.Repository;

import com.example.demo.Entity.UserRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolRepository extends JpaRepository<UserRol, Long> {
}
