package com.example.registrationloginwebapp.controllers;


import com.example.registrationloginwebapp.bootstrap.DataLoader;
import com.example.registrationloginwebapp.exceptions.NotFoundException;
import com.example.registrationloginwebapp.models.dtos.UserDto;
import com.example.registrationloginwebapp.usecases.UserSignUpUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserSignUpController {
    private static final Logger log = LoggerFactory.getLogger(DataLoader.class);

    private final UserSignUpUseCase userSignUpUseCase;

    public UserSignUpController(UserSignUpUseCase userSignUpUseCase) {
        this.userSignUpUseCase = userSignUpUseCase;
    }


    @RequestMapping({"/", "", "/sign-up"})
    public String signUpForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        //return "signupform";
        return "new";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("userDto") @Valid UserDto userDto,
                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }

        userSignUpUseCase.signUpUser(userDto);
        return "redirect:";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception) {

        log.error("Handling not found.");
        log.error(exception.getMessage());

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("404error");
        modelAndView.addObject("exception", exception);

        return modelAndView;
    }

}
