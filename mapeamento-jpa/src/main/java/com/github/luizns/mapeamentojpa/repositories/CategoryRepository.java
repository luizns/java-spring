package com.github.luizns.mapeamentojpa.repositories;

import com.github.luizns.mapeamentojpa.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
