package com.example.todoProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    ToDoRepository repository;

    @GetMapping("/todos")
    public List<ToDoItem> getToDoItems() {
        return repository.getToDoItems();
    }

    @GetMapping("/todos/{id}")
    public ToDoItem getToDoItem(@PathVariable String id) {
        return repository.getToDoItem(id).get();
    }

    @PostMapping("/todos")
    public ResponseEntity<ToDoItem> addToDoItem(@RequestBody ToDoItem toDoItem) {
        return new ResponseEntity<>(repository.addToDoItem(toDoItem), HttpStatus.CREATED);
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<ToDoItem> editToDoItem(@PathVariable String id, @RequestBody ToDoItem toDoItem) {
        toDoItem.setId(id);
        try {
            return new ResponseEntity<>(repository.editToDoItem(id, toDoItem), HttpStatus.OK);
        } catch (InvalidToDoItemIdException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<ToDoItem> deleteToDoItem(@PathVariable String id) {
        try {
            repository.deleteToDoItem(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (InvalidToDoItemIdException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
