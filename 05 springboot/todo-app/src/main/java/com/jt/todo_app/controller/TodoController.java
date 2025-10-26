package com.jt.todo_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jt.todo_app.service.TodoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TodoController {
  private final TodoService service;

  @GetMapping
  public String home(Model model) {
    model.addAttribute("todos", service.getTodos());
    return "index";
  }

  @PostMapping("/add")
  public String addTodo(@RequestParam String task) {
    service.createTodo(task);
    return "redirect:/";
  }

  @GetMapping("/toggle/{id}")
  public String toggleTodoById(@PathVariable int id) {
    service.toggleTodoById(id);
    return "redirect:/";
  }

  @GetMapping("/delete/{id}")
  public String deleteById(@PathVariable int id) {
    service.deleteTodoById(id);
    return "redirect:/";
  }
}
