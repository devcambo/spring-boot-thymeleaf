package com.devcambo.springbootthymeleaf.controller;

import com.devcambo.springbootthymeleaf.model.User;
import com.devcambo.springbootthymeleaf.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value ="/register", method = { RequestMethod.GET})
    public String displayRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value ="/createUser", method = { RequestMethod.POST})
    public String createUser(@Valid @ModelAttribute("user")User user, Errors errors) {
        if(errors.hasErrors()){
            return "register";
        }
        boolean isSaved = userService.save(user);
        log.info("User form is submitted successfully: {}", user);
        if(isSaved){
            return "redirect:/login?register=true";
        }else {
            return "register";
        }
    }

}
