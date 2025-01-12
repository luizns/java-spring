package com.github.luizns.jpalazy.repositories;

import com.github.luizns.jpalazy.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}