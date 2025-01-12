package com.github.luizns.jpalazy.controllers;


import com.github.luizns.jpalazy.dto.DepartmentDTO;
import com.github.luizns.jpalazy.dto.EmployeeMinDTO;
import com.github.luizns.jpalazy.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartmentDTO> findById(@PathVariable Long id) {
        DepartmentDTO obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/{id}/employees")
    public ResponseEntity<List<EmployeeMinDTO>> findEmployeesByDepartment(@PathVariable Long id) {
        List<EmployeeMinDTO> list = service.findEmployeesByDepartment(id);
        return ResponseEntity.ok(list);
    }
}