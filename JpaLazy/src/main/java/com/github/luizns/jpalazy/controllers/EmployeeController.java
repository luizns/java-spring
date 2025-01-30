package com.github.luizns.jpalazy.controllers;

import com.github.luizns.jpalazy.dto.EmployeeDepartmentDTO;
import com.github.luizns.jpalazy.dto.EmployeeMinDTO;
import com.github.luizns.jpalazy.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping(value = "/{id}/min")
    public ResponseEntity<EmployeeMinDTO> findByIdMin(@PathVariable Long id) {
        EmployeeMinDTO obj = service.findByIdMin(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDepartmentDTO> findByIdWithDepartment(@PathVariable Long id) {
        EmployeeDepartmentDTO obj = service.findByIdWithDepartment(id);
        return ResponseEntity.ok(obj);
    }

   // @GetMapping
    public ResponseEntity<List<EmployeeDepartmentDTO>> findEmployeesWithDepartments() {
        List<EmployeeDepartmentDTO> list = service.findEmployeesWithDepartments();
        return ResponseEntity.ok(list);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeMinDTO>> findByName(@RequestParam(name = "name",defaultValue = "")String name) {
        List<EmployeeMinDTO> result = service.findByName(name);
        return ResponseEntity.ok(result);
    }
}