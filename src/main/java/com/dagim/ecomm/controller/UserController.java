package com.dagim.ecomm.controller;

import com.dagim.ecomm.dto.UserDto;
import com.dagim.ecomm.dto.UserLoginDto;
import com.dagim.ecomm.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
@RequestMapping(path = {"/user"})
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = {"", "/"})
    public ModelAndView signupUser(Model model) {

        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return new ModelAndView("user/signup");
    }

    @PostMapping(path = {"", "/"})
    public ModelAndView createUser(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("user/signup");
        } else {
            userService.createUserProfile(userDto);
            return new ModelAndView("redirect:user/login");
        }
    }

    @GetMapping("/login")
    public ModelAndView loginUser(Model model) {
        UserLoginDto userLoginDto = new UserLoginDto();
        model.addAttribute("userLoginDto", userLoginDto);
        return new ModelAndView("user/login");
    }

    @PostMapping("/login")
    public ModelAndView loginUser(@Valid @ModelAttribute UserLoginDto userLoginDto, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ModelAndView("user/login");
        else {
            if (userService.validateUserCredential(userLoginDto)) {
                log.info("Login Succeeded");
                model.addAttribute("userDto", userService.findUserByEmail(userLoginDto.getEmail()));
                return new ModelAndView("user/myaccount");
//                return "redirect:/products";
            } else {
                bindingResult.rejectValue("password", "wrongCredential", "Either the email or password provided is incorrect!");
                return new ModelAndView("user/login");
            }
        }
    }

    @GetMapping("/myaccount")
    public ModelAndView userProfile(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return new ModelAndView("user/myaccount");
    }

}
