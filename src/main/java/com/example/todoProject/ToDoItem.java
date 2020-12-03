package com.example.todoProject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class ToDoItem {
    private String name;
    private Integer id;
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
        this.createdAt = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        this.updatedAt = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        this.id = createID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private static AtomicInteger idCounter = new AtomicInteger();

    public static Integer createID()
    {
        return Integer.valueOf(idCounter.getAndIncrement());
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
        this.updatedAt = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }



}
