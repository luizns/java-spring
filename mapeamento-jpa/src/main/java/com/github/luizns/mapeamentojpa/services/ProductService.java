package com.github.luizns.mapeamentojpa.services;

import com.github.luizns.mapeamentojpa.dto.ProductDTO;
import com.github.luizns.mapeamentojpa.entities.Category;
import com.github.luizns.mapeamentojpa.entities.Product;
import com.github.luizns.mapeamentojpa.repositories.CategoryRepository;
import com.github.luizns.mapeamentojpa.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    public ProductDTO insert(ProductDTO dto) {
        Product entity = new Product();
        entity.setId(dto.id());
        entity.setName(dto.name());
        entity.setPrice(dto.price());

        entity.getCategories().addAll(
                dto.categories().stream()
                        .map(catDTO -> {
                            // Category cat = new Category();
                            // cat.setId(catDTO.id());
                            return categoryRepository.getReferenceById(catDTO.id());
                        })
                        .toList() // Converte o fluxo para uma lista
        );
        entity = repository.save(entity);
        return new ProductDTO(entity);

    }
}
