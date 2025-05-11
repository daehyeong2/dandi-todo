package com.todo.todo.dto;

import lombok.Getter;

@Getter
public class DeleteToDoRes extends BaseRes {

  public DeleteToDoRes(Boolean ok) {
    super(ok);
  }
}
