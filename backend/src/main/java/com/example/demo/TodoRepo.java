package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class TodoRepo {

    private HashMap<String, Todo> todos = new HashMap<>();

    public void create(Todo todo){
        todos.putIfAbsent(todo.getId(), todo);
    }

    public TodoRepo(List<Todo> todos){
        for(Todo t : todos) this.todos.putIfAbsent(t.getId(), t);
    }

    public Optional<Todo> get(String id){
        Optional<Todo> todoReturn = Optional.of(todos.get(id));
        return todoReturn;
    }

    public Optional<List<Todo>> list(){
        Optional<List<Todo>> listReturn = Optional.of(new ArrayList<>(todos.values()));
        return listReturn;
    }
/*
    public void changeStatus(String id, String status) {
        Todo todo = todos.get(id);
    }
    */
}
