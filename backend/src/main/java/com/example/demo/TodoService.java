package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepo todoRepo;

    public void createTodo(Todo todo){
        todoRepo.create(todo);
    }

    public void editTodo(Todo todo){
        todoRepo.edit(todo);
    }

    public void delete(String id){
        todoRepo.delete(id);
    }

    public Optional<List<Todo>> listTodos(){
        return todoRepo.list();
    }

    public Optional<Todo> getTodo(String id){
        return todoRepo.get(id);
    }

    public void changeStatus(Todo todo) {
        if(todo.getStatus().equals("OPEN")) {
            todo.setStatus("IN_PROGRESS");
            todoRepo.edit(todo);
        } else if(todo.getStatus().equals("IN_PROGRESS")) {
            todo.setStatus("DONE");
            todoRepo.edit(todo);
        } else if(todo.getStatus().equals("DONE")) {
            todoRepo.delete(todo.getId());
        };
    }

}
