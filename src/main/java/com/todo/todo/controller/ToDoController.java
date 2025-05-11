package com.todo.todo.controller;

import com.todo.todo.dto.CreateToDoReq;
import com.todo.todo.dto.CreateToDoRes;
import com.todo.todo.dto.DeleteToDoReq;
import com.todo.todo.dto.DeleteToDoRes;
import com.todo.todo.dto.FindAllToDoRes;
import com.todo.todo.dto.FindByIdToDoReq;
import com.todo.todo.dto.FindByIdToDoRes;
import com.todo.todo.dto.ToggleToDoReq;
import com.todo.todo.dto.ToggleToDoRes;
import com.todo.todo.dto.UpdateToDoReq;
import com.todo.todo.dto.UpdateToDoRes;
import com.todo.todo.service.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class ToDoController {
  ToDoService toDoService;

  @GetMapping("/todos")
  public ResponseEntity<FindAllToDoRes> findAllToDo() {
    return toDoService.findAllToDo();
  }

  @PostMapping("/todos")
  public ResponseEntity<CreateToDoRes> createToDo(@RequestBody CreateToDoReq createToDoReq) {
    return toDoService.createToDo(createToDoReq);
  }

  @PatchMapping("/todos")
  public ResponseEntity<UpdateToDoRes> updateToDo(@RequestBody UpdateToDoReq updateToDoReq) {
    return toDoService.updateToDo(updateToDoReq);
  }

  @DeleteMapping("/todos")
  public ResponseEntity<DeleteToDoRes> deleteToDo(@RequestBody DeleteToDoReq deleteToDoReq){
    return toDoService.deleteToDo(deleteToDoReq);
  }

  @PostMapping("/todos/toggle")
  public ResponseEntity<ToggleToDoRes> toggleToDo(@RequestBody ToggleToDoReq toggleToDoReq) {
    return toDoService.toggleToDo(toggleToDoReq);
  }

  @GetMapping("/todos/findById")
  public ResponseEntity<FindByIdToDoRes> findById(@RequestBody FindByIdToDoReq findByIdToDoReq) {
    return toDoService.findById(findByIdToDoReq);
  }
}
