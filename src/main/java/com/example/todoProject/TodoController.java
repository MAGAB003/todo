package com.example.todoProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    ToDoRepository repository;

    @GetMapping("/todo")
    public List<ToDoItem> getToDoItems() {
        return repository.getToDoItems();
    }

    @GetMapping("/todo/{id}")
    public ToDoItem getToDoItem(@PathVariable Integer id) {
        return repository.getToDoItem(id);
    }

    @PostMapping("/todo")
    public ToDoItem addToDoItem(@RequestBody ToDoItem toDoItem) {
        return repository.addToDoItem(toDoItem);
    }

    @PutMapping("/todo/{id}")
    public ToDoItem editToDoItem(@PathVariable Integer id, @RequestBody ToDoItem toDoItem) {
        return repository.editToDoItem(toDoItem);
    }

    @DeleteMapping("/todo/{id}")
    public void deleteToDoItem(@PathVariable Integer id) {
        repository.deleteToDoItem(id);
    }
}
