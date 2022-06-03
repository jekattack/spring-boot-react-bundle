package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/kanban")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getAllTodos() {

        return todoService.listTodos().orElseThrow();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createTodo(@RequestBody Todo todo){
        todoService.createTodo(todo);
    }

}