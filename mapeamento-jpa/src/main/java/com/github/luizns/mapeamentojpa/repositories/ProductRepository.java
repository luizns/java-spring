package com.github.luizns.mapeamentojpa.repositories;

import com.github.luizns.mapeamentojpa.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}