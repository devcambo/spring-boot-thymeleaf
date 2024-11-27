package com.devcambo.springbootthymeleaf.controller;

import com.devcambo.springbootthymeleaf.model.Category;
import com.devcambo.springbootthymeleaf.repo.CategoryRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@Slf4j
public class CategoryController {

    @Autowired
    CategoryRepo categoryRepo;

    @RequestMapping("/category")
    public String displayCategoryPage(Model model) {
        List<Category> categories = categoryRepo.findAll();
            model.addAttribute("categories", categories);
        model.addAttribute("category", new Category());
        return "category";
    }

    @RequestMapping(value = "/saveCategory", method = {RequestMethod.POST})
    public String createCategory(@ModelAttribute("category") Category category) {
        categoryRepo.save(category);
        log.info("Category form is submitted successfully: {}", category.getName());
        return "redirect:/category";
    }

    @RequestMapping(value = "/delCategory/{id}", method = {RequestMethod.DELETE})
    public String createCategory(@PathVariable int id) {
        try {
            categoryRepo.deleteById(id);
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
        }
        return "redirect:/category";
    }

}
