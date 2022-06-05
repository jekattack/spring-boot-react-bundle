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

    public List<Todo> listTodos(){
        return todoRepo.list().orElseThrow();
    }

    public Todo getTodo(String id){
        return todoRepo.get(id).orElseThrow();
    }

    public void createTodo(Todo todo){
        if (todo.getTask()!=""){todoRepo.create(todo);}
    }

    public void editTodo(Todo todo){
        todoRepo.edit(todo);
    }

    public void delete(String id){
        todoRepo.delete(id);
    }

    public void changeNext(Todo todo) {
        todoRepo.changeNext(todo);
    }

    public void changePrev(Todo todo) {
        todoRepo.changePrev(todo);
    }


}
