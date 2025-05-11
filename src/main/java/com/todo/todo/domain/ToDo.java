package com.todo.todo.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ToDo extends Base {
  private String title;
  private String description;
  private boolean done = false;

  public void update(String title, String description) {
    this.title = title;
    this.description = description;
  }

  public void toggleDone() {
    this.done = !this.done;
  }
}
