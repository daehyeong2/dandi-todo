package com.todo.todo.dto;


import lombok.Getter;

@Getter
public class CreateToDoRes extends BaseRes {
  Long toDoId;

  public CreateToDoRes(Boolean ok, Long toDoId) {
    super(ok);
    this.toDoId = toDoId;
  }
}
