package com.example.registrationloginwebapp.controller;

import com.example.registrationloginwebapp.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

//TODO
@Controller
@RequestMapping("/signup")
public class UserSignUpController {
   @ModelAttribute("user")
    public UserDto userDto(){
        return new UserDto();
    };

    //TODO
    @GetMapping
    public String showSignUpForm(Model model){
        model.addAttribute("user", userDto());
        return "signUpForm";
    }
}
