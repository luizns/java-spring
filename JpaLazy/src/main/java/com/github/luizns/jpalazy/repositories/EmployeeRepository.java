package com.github.luizns.jpalazy.repositories;

import com.github.luizns.jpalazy.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT obj FROM Employee obj JOIN FETCH obj.department")
    List<Employee> findEmployeesWithDepartments();

    List<Employee> findByNameContainingIgnoreCase(String name);
}