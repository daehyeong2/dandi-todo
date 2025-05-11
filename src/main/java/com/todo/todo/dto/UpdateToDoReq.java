package com.todo.todo.dto;

import lombok.Getter;

@Getter
public class UpdateToDoReq {
  Long id;
  String title;
  String description;
}
