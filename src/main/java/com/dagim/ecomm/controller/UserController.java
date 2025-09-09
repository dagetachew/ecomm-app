package com.dagim.ecomm.controller;

import com.dagim.ecomm.model.ProductTbl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = {"/user"})
public class UserController {

    @GetMapping(path = {"", "/"})
    public String listProducts(Model model) {

//        List<ProductTbl> productTblList = productService.findAllProducts();
//        model.addAttribute("products", productTblList);
        return "user/signup";
    }

}
