package com.github.luizns.jpa.repositories;

import com.github.luizns.jpa.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}