package com.jt.jt_blogs.controller;

import com.jt.jt_blogs.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BlogController {
    private final BlogService service;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("blogs", service.getBlogs());
        return "home";
    }
}
