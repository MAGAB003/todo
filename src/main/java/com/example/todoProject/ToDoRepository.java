package com.example.todoProject;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ToDoRepository {

    TodoMongoRepository tmr;

    ToDoRepository(TodoMongoRepository tmr) {
        this.tmr = tmr;
    }

    // Get all ToDoItems
    public List<ToDoItem> getToDoItems() {
        return tmr.findAll();
    }

    // Get one ToDoItem
    public Optional<ToDoItem> getToDoItem(String id) {
        return tmr.findById(id);
    }

    // Add a ToDoItem
    public ToDoItem addToDoItem(ToDoItem toDoItem) {
        tmr.insert(toDoItem);
        return toDoItem;
    }

    // Edit a ToDoItem
    public ToDoItem editToDoItem(String id, ToDoItem toDoItem) throws InvalidToDoItemIdException {
        Optional<ToDoItem> response = tmr.findById(id);
        if (!response.isPresent()) {
            throw new InvalidToDoItemIdException();
        }

        ToDoItem toDoItemToEdit = response.get();
        if (toDoItem.getName() != null) toDoItemToEdit.setName(toDoItem.getName());
        if (toDoItem.getCategory() != null) toDoItemToEdit.setCategory(toDoItem.getCategory());
        if (toDoItem.getDescription() != null) toDoItemToEdit.setDescription(toDoItem.getDescription());
        if (toDoItem.getDone() != null) toDoItemToEdit.setDone(toDoItem.getDone());
        toDoItemToEdit.setUpdatedAt();
        tmr.save(toDoItemToEdit);
        return toDoItemToEdit;
    }

    // Delete a ToDoItem
    public void deleteToDoItem(String id) throws InvalidToDoItemIdException {
        Optional<ToDoItem> response = tmr.findById(id);
        if (!response.isPresent()) {
            throw new InvalidToDoItemIdException();
        }
        tmr.deleteById(id);
    }

}

interface TodoMongoRepository extends MongoRepository<ToDoItem, String> {
}
