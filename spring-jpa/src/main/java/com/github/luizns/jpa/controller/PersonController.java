package com.github.luizns.jpa.controller;

import com.github.luizns.jpa.dto.PersonDTO;
import com.github.luizns.jpa.dto.PersonDepartmentDTO;
import com.github.luizns.jpa.services.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/people")
public class PersonController {
    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

//    @PostMapping
    public ResponseEntity<PersonDepartmentDTO> insert(@RequestBody PersonDepartmentDTO dto) {

        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.id())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PostMapping
    public ResponseEntity<PersonDTO> insert(@RequestBody PersonDTO dto) {

        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.id())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
