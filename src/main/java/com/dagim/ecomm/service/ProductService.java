package com.dagim.ecomm.service;

import com.dagim.ecomm.model.ProductTbl;
import com.dagim.ecomm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductTbl> findAllProducts() {
        return productRepository.findAll();
    }
}
