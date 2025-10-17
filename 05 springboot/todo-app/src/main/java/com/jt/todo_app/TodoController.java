package com.jt.todo_app;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {
  @GetMapping
  public String home(Model model) {
    model.addAttribute("todos", List.of("Eat", "Sleep", "Code", "Repeat"));
    return "index";
  }
}
