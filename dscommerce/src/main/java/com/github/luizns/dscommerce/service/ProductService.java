package com.github.luizns.dscommerce.service;

import com.github.luizns.dscommerce.DTO.ProductDTO;
import com.github.luizns.dscommerce.entities.Product;
import com.github.luizns.dscommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product product = repository.findById(id).get();
        return new ProductDTO(product);
    }
}
