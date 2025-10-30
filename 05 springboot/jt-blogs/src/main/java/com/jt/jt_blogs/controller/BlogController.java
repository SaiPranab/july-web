package com.jt.jt_blogs.controller;

import com.jt.jt_blogs.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class BlogController {
  private final BlogService service;

  @GetMapping
  public String home(Model model) {
    model.addAttribute("blogs", service.getBlogs());
    return "home";
  }

  @GetMapping("/form")
  public String form() {
    return "add-blog";
  }

  @PostMapping("/add-blog")
  public String addBlog(@RequestParam String heading, @RequestParam String description) {
    service.createBlog(heading, description);
    return "redirect:/";
  }
}
