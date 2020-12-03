package com.example.todoProject;

import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    // get one toDoItem
    public ToDoItem getToDoItem(Integer id) {
        for (ToDoItem toDoItem : toDoItems) {
            if (toDoItem.getId().equals(id)) {
                return toDoItem;
            }
        }
        return null;
    }

    // get all toDoItems
    public List<ToDoItem> getToDoItems() {
        return toDoItems;
    }

    // add a toDoItem
    public ToDoItem addToDoItem(ToDoItem toDoItem) {
        ToDoItem lastToDoItem = toDoItems.get(toDoItems.size()-1);
        toDoItem.setId(lastToDoItem.getId()+1); // set an id on the new toDoItem, should be unique, will be done by the database in future exercises
        toDoItems.add(toDoItem);
        return toDoItem;
    }

    // edit a toDoItem
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

    // delete a toDoItem
    public void deleteToDoItem(Integer id) {
        ToDoItem toDoItemToDelete = this.getToDoItem(id);
        if (toDoItemToDelete != null) {
            toDoItems.remove(toDoItemToDelete);
        }
    }
}
