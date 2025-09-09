package com.dagim.ecomm.controller;

import com.dagim.ecomm.dto.UserDto;
import com.dagim.ecomm.dto.UserLoginDto;
import com.dagim.ecomm.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"/user"})
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = {"", "/"})
    public String signupUser(Model model) {

        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "user/signup";
    }

    @PostMapping(path = {"", "/"})
    public String createUser(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/signup";
        }else {
            userService.createUserProfile(userDto);
            return "redirect:user/login";
        }
    }

    @GetMapping("/login")
    public String loginUser(Model model) {
        UserLoginDto userLoginDto = new UserLoginDto();
        model.addAttribute("userLoginDto", userLoginDto);
        return "user/login";
    }

    @PostMapping("/login")
    public String loginUser(@Valid @ModelAttribute UserLoginDto userLoginDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "user/login";
        else{
            return "redirect:/products";
        }
    }

}
