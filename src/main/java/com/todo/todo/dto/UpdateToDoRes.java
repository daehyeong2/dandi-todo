package com.todo.todo.dto;

import lombok.Getter;

@Getter
public class UpdateToDoRes extends BaseRes {
  Long toDoId;

  public UpdateToDoRes(Boolean ok, Long toDoId) {
    super(ok);
    this.toDoId = toDoId;
  }
}
