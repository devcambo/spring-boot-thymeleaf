package com.devcambo.springbootthymeleaf.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Slf4j
public class PostController {

    @GetMapping("/post/{id}")
    public String DisplayPostDetail(@PathVariable("id") String postId, Model model) {
        log.info("The id of the post is {} ", postId);
        return "post";
    }

}
