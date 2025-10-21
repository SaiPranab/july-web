package com.jt.todo_app;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {
  private final List<Todo> todos;

  public TodoController(List<Todo> todos) {
    this.todos = todos;
  }

  @GetMapping
  public String home(Model model) {
    model.addAttribute("todos", todos);
    return "index";
  }

  @PostMapping("/add")
  public String addTodo(@RequestParam String task) {
    if (task != null && !task.isEmpty() && !task.isBlank()) {
      Todo todo = new Todo(0, task, false);
      todos.add(todo);
    }

    return "redirect:/";
  }

}
