package com.jt.todo_app;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {
  private final List<Todo> todos;
  private static int idCounter = 0;

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
      Todo todo = new Todo(++idCounter, task, false);
      todos.add(todo);
    }

    return "redirect:/";
  }

  @GetMapping("/toggle/{id}")
  public String toggleTodoById(@PathVariable int id) {
    Optional<Todo> optTodo = getTodoById(id);
    // if(optTodo.isPresent()) {
    // Todo todo = optTodo.get();
    // todo.setCompleted(!todo.isCompleted());
    // }
    optTodo.ifPresent((todo) -> todo.setCompleted(!todo.isCompleted()) );
    return "redirect:/";
  }

  @GetMapping("/delete/{id}")
  public String deleteById(@PathVariable int id) {
    getTodoById(id).ifPresent((todo) -> todos.remove(todo));
    return "redirect:/";
  }

  private Optional<Todo> getTodoById(int id) {
    // for (Todo todo : todos) {
    //   if (todo.getId() == id) {
    //     return Optional.of(todo);
    //   }
    // }
    // return Optional.empty();
    
    return todos.stream().filter(todo -> todo.getId() == id).findFirst();
  }
}
