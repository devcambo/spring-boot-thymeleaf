package com.devcambo.springbootthymeleaf.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class AuthorController {

    @RequestMapping("/author/{id}")
    public String displayAuthorPage(@PathVariable("id") String authorId, Model model) {
        log.info("The id of the author is {} ", authorId);
        return "author";
    }

}
