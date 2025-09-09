package com.dagim.ecomm.service;

import com.dagim.ecomm.model.ProductEntity;
import com.dagim.ecomm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> findAllProducts() {
        return productRepository.findAll();
    }
}
