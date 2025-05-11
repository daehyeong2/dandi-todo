package com.todo.todo.service;

import com.todo.todo.domain.ToDo;
import com.todo.todo.dto.CreateToDoReq;
import com.todo.todo.dto.CreateToDoRes;
import com.todo.todo.dto.FindAllToDoRes;
import com.todo.todo.dto.ToggleToDoReq;
import com.todo.todo.dto.ToggleToDoRes;
import com.todo.todo.dto.UpdateToDoReq;
import com.todo.todo.dto.UpdateToDoRes;
import com.todo.todo.repository.ToDoRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class ToDoService {
  private final ToDoRepository toDoRepository;

  public ResponseEntity<CreateToDoRes> createToDo(CreateToDoReq toDo){
    if(toDo.getTitle() == null || toDo.getDescription() == null) return new ResponseEntity<>(new CreateToDoRes(
        false,
        null
    ), HttpStatus.BAD_REQUEST);
    ToDo newToDo = new ToDo();
    newToDo.update(
        toDo.getTitle(),
        toDo.getDescription()
    );
    toDoRepository.save(newToDo);
    return new ResponseEntity<>(new CreateToDoRes(
        true,
        newToDo.getId()
    ), HttpStatus.CREATED);
  }

  public Optional<ToDo> findById(Long id) {
    return toDoRepository.findById(id);
  }

  public ResponseEntity<UpdateToDoRes> updateToDo(UpdateToDoReq updateToDoReq) {
    if (updateToDoReq.getId() == null)
      return new ResponseEntity<>(new UpdateToDoRes(false, null), HttpStatus.BAD_REQUEST);
    Optional<ToDo> toDo = toDoRepository.findById(updateToDoReq.getId());
    if (toDo.isEmpty())
      return new ResponseEntity<>(new UpdateToDoRes(false, null), HttpStatus.NOT_FOUND);
    ToDo newToDo = toDo.get();
    if (updateToDoReq.getTitle() != null)
      newToDo.setTitle(updateToDoReq.getTitle());
    if (updateToDoReq.getDescription() != null)
      newToDo.setDescription(updateToDoReq.getDescription());
    toDoRepository.save(newToDo);
    return new ResponseEntity<>(new UpdateToDoRes(true, newToDo.getId()), HttpStatus.OK);
  }

  public ResponseEntity<FindAllToDoRes> findAllToDo() {
    List<ToDo> todos = toDoRepository.findAll();
    return new ResponseEntity<>(new FindAllToDoRes(true, todos), HttpStatus.OK);
  }

  public ResponseEntity<ToggleToDoRes> toggleToDo(ToggleToDoReq toggleToDoReq) {
    if(toggleToDoReq.getId() == null) return new ResponseEntity<>(new ToggleToDoRes(false), HttpStatus.BAD_REQUEST);
    Optional<ToDo> toDoRes = toDoRepository.findById(toggleToDoReq.getId());
    if(toDoRes.isEmpty()) return new ResponseEntity<>(new ToggleToDoRes(false), HttpStatus.NOT_FOUND);
    ToDo toDo = toDoRes.get();
    toDo.toggleDone();
    toDoRepository.save(toDo);
    return new ResponseEntity<>(new ToggleToDoRes(true), HttpStatus.OK);
  }
}
