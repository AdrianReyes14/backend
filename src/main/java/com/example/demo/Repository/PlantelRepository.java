package com.example.demo.Repository;

import com.example.demo.Entity.Plantel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantelRepository extends JpaRepository<Plantel,Long> {
}
