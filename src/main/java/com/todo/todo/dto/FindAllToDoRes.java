package com.todo.todo.dto;

import com.todo.todo.domain.ToDo;
import java.util.List;
import lombok.Getter;

@Getter
public class FindAllToDoRes extends BaseRes {
  List<ToDo> todos;

  public FindAllToDoRes(Boolean ok, List<ToDo> todos) {
    super(ok);
    this.todos = todos;
  }
}
