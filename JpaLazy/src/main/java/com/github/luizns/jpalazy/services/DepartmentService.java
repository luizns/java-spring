package com.github.luizns.jpalazy.services;

import com.github.luizns.jpalazy.dto.DepartmentDTO;
import com.github.luizns.jpalazy.dto.EmployeeMinDTO;
import com.github.luizns.jpalazy.entities.Department;
import com.github.luizns.jpalazy.entities.Employee;
import com.github.luizns.jpalazy.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

;import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Transactional(readOnly = true)
    public DepartmentDTO findById(Long id) {
        Optional<Department> result = repository.findById(id);
        return new DepartmentDTO(result.get());
    }

    @Transactional(readOnly = true)
    public List<EmployeeMinDTO> findEmployeesByDepartment(Long id) {
        Optional<Department> result = repository.findById(id);
        List<Employee> list = result.get().getEmployees();
        return list.stream().map(EmployeeMinDTO::new).toList();
    }
}