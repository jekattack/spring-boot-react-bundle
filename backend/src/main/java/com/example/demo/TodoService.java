package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepo todoRepo;

    public void createTodo(Todo todo){
        todoRepo.create(todo);
    }
    public Optional<List<Todo>> listTodos(){
        return todoRepo.list();
    }

    /*
    public void changeStatus(String status){
        todoRepo.changeStatus(status);
    }
    */

}
