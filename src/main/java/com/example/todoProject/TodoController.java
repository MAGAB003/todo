package com.example.todoProject;

import org.springframework.beans.factory.annotation.Autowired;
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
    public ToDoItem getToDoItem(@PathVariable Integer id) {
        return repository.getToDoItem(id);
    }

    @PostMapping("/todos")
    public ToDoItem addToDoItem(@RequestBody ToDoItem toDoItem) {
        return repository.addToDoItem(toDoItem);
    }

    @PutMapping("/todos/{id}")
    public ToDoItem editToDoItem(@PathVariable Integer id, @RequestBody ToDoItem toDoItem) {
        toDoItem.setId(id);
        return repository.editToDoItem(toDoItem);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteToDoItem(@PathVariable Integer id) {
        repository.deleteToDoItem(id);
    }

}
