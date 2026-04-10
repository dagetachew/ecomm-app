package com.dagim.ecomm.controller;

import com.dagim.ecomm.model.ProductEntity;
import com.dagim.ecomm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(path = {"/products"})
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = {"", "/"})
    public ModelAndView listProducts(Model model) {

        List<ProductEntity> productEntityList = productService.findAllProducts();
        model.addAttribute("products", productEntityList);
        return new ModelAndView("products/index");
    }
}
