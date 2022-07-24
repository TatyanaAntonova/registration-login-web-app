package com.example.registrationloginwebapp.controllers;


import com.example.registrationloginwebapp.models.dtos.UserDto;
import com.example.registrationloginwebapp.usecases.UserSignUpUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//TODO
@Controller
public class UserSignUpController {
    private final UserSignUpUseCase userSignUpUseCase;

    public UserSignUpController(UserSignUpUseCase userSignUpUseCase) {
        this.userSignUpUseCase = userSignUpUseCase;
    }


    @RequestMapping({"/", "", "/sign-up"})
    public String signUpForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "signupform";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "error";
        }

        System.out.println("from controller " + userSignUpUseCase.signUpUser(userDto));
        return "redirect:";
    }

}
