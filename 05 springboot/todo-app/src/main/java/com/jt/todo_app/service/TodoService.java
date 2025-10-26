package com.jt.todo_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jt.todo_app.model.Todo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {
  private final List<Todo> todos;
  private static int idCounter = 0;

  public List<Todo> getTodos() {
    return todos;
  }

  public void createTodo(String task) {
    if (task != null && !task.isEmpty() && !task.isBlank()) {
      Todo todo = new Todo(++idCounter, task, false);
      todos.add(todo);
    }
  }

  public void toggleTodoById(int id) {
    getTodoById(id).ifPresent((todo) -> todo.setCompleted(!todo.isCompleted()));
  }

  public void deleteTodoById(int id) {
    getTodoById(id).ifPresent((todo) -> todos.remove(todo));
  }

  private Optional<Todo> getTodoById(int id) {
    return todos.stream().filter(todo -> todo.getId() == id).findFirst();
  }
}
