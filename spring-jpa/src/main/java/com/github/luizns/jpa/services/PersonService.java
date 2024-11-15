package com.github.luizns.jpa.services;

import com.github.luizns.jpa.dto.DepartmentDTO;
import com.github.luizns.jpa.dto.PersonDTO;
import com.github.luizns.jpa.dto.PersonDepartmentDTO;
import com.github.luizns.jpa.entities.Department;
import com.github.luizns.jpa.entities.Person;
import com.github.luizns.jpa.repositories.DepartmentRepository;
import com.github.luizns.jpa.repositories.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository repository;
    private final DepartmentRepository departmentRepository;

    public PersonService(PersonRepository repository, DepartmentRepository departmentRepository) {
        this.repository = repository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public PersonDTO insert(PersonDTO dto) {

        Person entity = new Person();
        entity.setName(dto.name());
        entity.setSalary(dto.salary());
        entity.setDepartment(departmentRepository.getReferenceById(dto.departmentId()));

        entity = repository.save(entity);

        return convertToPersonDTO(entity);
    }

    @Transactional
    public PersonDepartmentDTO insert(PersonDepartmentDTO dto) {

        Person entity = new Person();
        entity.setName(dto.name());
        entity.setSalary(dto.salary());

        entity.setDepartment(createDepartmentFromDTO(dto.department()));

        entity = repository.save(entity);

        return convertToPersonDepartmentDTO(entity);
    }

    private Department createDepartmentFromDTO(DepartmentDTO departmentDTO) {
        return departmentRepository.getReferenceById(departmentDTO.id());
    }

    private PersonDTO convertToPersonDTO(Person entity) {
        return new PersonDTO(
                entity.getId(),
                entity.getName(),
                entity.getSalary(),
                entity.getDepartment().getId()
        );
    }

    private PersonDepartmentDTO convertToPersonDepartmentDTO(Person entity) {
        DepartmentDTO departmentDTO = new DepartmentDTO(
                entity.getDepartment().getId(),
                entity.getDepartment().getName()
        );

        return new PersonDepartmentDTO(
                entity.getId(),
                entity.getName(),
                entity.getSalary(),
                departmentDTO
        );
    }
}
