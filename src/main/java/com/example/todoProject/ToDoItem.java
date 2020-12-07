package com.example.todoProject;

import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;

public class ToDoItem {

    private String name;
    @Id
    private String id;
    private Boolean done;
    private String category;
    private String description;
    private String updatedAt;
    private String createdAt;

    public ToDoItem(String name, String category, String description) {
        this.name = name;
        this.done = false;
        this.category = category;
        this.description = description;
        this.updatedAt = this.createdAt = Instant.now().toString();
    }

    private static AtomicInteger idCounter = new AtomicInteger();

    public static Integer createID() {
        return idCounter.incrementAndGet();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt() {
        this.updatedAt =  Instant.now().toString();
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
