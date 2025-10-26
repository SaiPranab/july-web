package com.jt.todo_app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
  private int id;
  private String task;
  private boolean completed;

  // public int getId() {
  //   return id;
  // }

  // public void setId(int id) {
  //   this.id = id;
  // }

  // public String getTask() {
  //   return task;
  // }

  // public void setTask(String task) {
  //   this.task = task;
  // }

  // public boolean isCompleted() {
  //   return completed;
  // }

  // public void setCompleted(boolean completed) {
  //   this.completed = completed;
  // }

  // public Todo(int id, String task, boolean completed) {
  //   this.id = id;
  //   this.task = task;
  //   this.completed = completed;
  // }
}
