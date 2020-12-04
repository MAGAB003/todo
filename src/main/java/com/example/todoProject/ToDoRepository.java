package com.example.todoProject;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ToDoRepository {

    private List<ToDoItem> toDoItems;

    public ToDoRepository() {
        toDoItems = new ArrayList<>();
        toDoItems.add(new ToDoItem("Clean up", "Household", "Clean up your mess"));
        toDoItems.add(new ToDoItem("Finish web app", "Development", "Finish project"));
        toDoItems.add(new ToDoItem("Cook dinner", "Household", "Cook dinner for the family"));
        toDoItems.add(new ToDoItem("Buy milk", "Shopping", "Buy a lot of milk"));
    }

    // Get all ToDoItems
    public List<ToDoItem> getToDoItems() {
        return toDoItems;
    }

    // Get one ToDoItem
    public ToDoItem getToDoItem(Integer id) {
        for (ToDoItem toDoItem : toDoItems) {
            if (toDoItem.getId().equals(id)) {
                return toDoItem;
            }
        }
        return null;
    }

    // Add a ToDoItem
    public ToDoItem addToDoItem(ToDoItem toDoItem) {
        toDoItems.add(toDoItem);
        return toDoItem;
    }

    // Edit a ToDoItem
    public ToDoItem editToDoItem(ToDoItem toDoItem) {
        ToDoItem toDoItemToEdit = this.getToDoItem(toDoItem.getId());
        if (toDoItemToEdit != null) {
            toDoItemToEdit.setName(toDoItem.getName());
            toDoItemToEdit.setDone(toDoItem.getDone());
            toDoItemToEdit.setCategory(toDoItem.getCategory());
            toDoItemToEdit.setDescription(toDoItem.getDescription());
            toDoItemToEdit.setUpdatedAt();
        }
        return toDoItemToEdit;
    }

    // Delete a ToDoItem
    public void deleteToDoItem(Integer id) {
        ToDoItem toDoItemToDelete = this.getToDoItem(id);
        if (toDoItemToDelete != null) {
            toDoItems.remove(toDoItemToDelete);
        }
    }
}
