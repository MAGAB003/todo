package com.example.todoProject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {


    @GetMapping("/")
    public String todo(){
         return "index";
    }
}
