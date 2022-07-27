package com.example.registrationloginwebapp.controllers;

import com.example.registrationloginwebapp.models.UserDto;
import com.example.registrationloginwebapp.usecases.UserSignUpUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserSignUpController {
    private static final Logger log = LoggerFactory.getLogger(UserSignUpController.class);
    private final UserSignUpUseCase userSignUpUseCase;

    public UserSignUpController(UserSignUpUseCase userSignUpUseCase) {
        this.userSignUpUseCase = userSignUpUseCase;
    }

    @GetMapping({"/", "/sign-up"})
    public String signUpForm(@ModelAttribute("user") UserDto userDto) {
        return "signupform";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto,
                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();

            log.error("UserDto Problem.");
            for (FieldError fieldError : fieldErrors) {
                log.error("errors --" + fieldError.getField() + fieldError.getDefaultMessage());
            }

            return "signupform";
        }

        userSignUpUseCase.signUpUser(userDto);
        return "redirect:welcome";
    }

    @GetMapping("/welcome")
    public String welcomePage() {
        return "welcome";
    }

/*
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception) {

        log.error("Handling not found.");
        log.error(exception.getMessage());

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("404error");
        modelAndView.addObject("exception", exception);

        return modelAndView;
    }*/

}
