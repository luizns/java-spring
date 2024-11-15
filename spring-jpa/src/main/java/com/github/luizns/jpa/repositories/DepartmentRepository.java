package com.github.luizns.jpa.repositories;

import com.github.luizns.jpa.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
