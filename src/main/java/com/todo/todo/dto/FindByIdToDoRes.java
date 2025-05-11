package com.todo.todo.dto;

import com.todo.todo.domain.ToDo;
import lombok.Getter;

@Getter
public class FindByIdToDoRes extends BaseRes {
  ToDo toDo;

  public FindByIdToDoRes(Boolean ok, ToDo toDo) {
    super(ok);
    this.toDo = toDo;
  }
}
