package com.github.luizns.jpa.dto;

public record PersonDepartmentDTO(Long id, String name, Double salary, DepartmentDTO department) {
}
