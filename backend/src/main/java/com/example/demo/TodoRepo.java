package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class TodoRepo {

    private HashMap<String, Todo> todos = new HashMap<>();
    public TodoRepo(List<Todo> todos){
        for(Todo t : todos) this.todos.putIfAbsent(t.getId(), t);
    }

    public void create(Todo todo){
        todos.putIfAbsent(todo.getId(), todo);
    }
    public void edit(Todo todo){
        todos.put(todo.getId(), todo);
    }

    public Optional<Todo> get(String id){
        Optional<Todo> todoReturn = Optional.of(todos.get(id));
        return todoReturn;
    }

    public void delete(String id){
        todos.remove(id);
    }


    public Optional<List<Todo>> list(){
        Optional<List<Todo>> listReturn = Optional.of(new ArrayList<>(todos.values()));
        return listReturn;
    }

    public void changeNext(Todo todo) {
        todo.setStatus(todo.getStatus().progressNext());
        edit(todo);
    }

    public void changePrev(Todo todo) {
        todo.setStatus(todo.getStatus().progressPrev());
        edit(todo);
    }

}
