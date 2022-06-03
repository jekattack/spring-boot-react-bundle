package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private TodoService todoService;

    @Test
    void shouldReturnGivenTodo(){
        //Given
        Todo todo = new Todo(TodoStatus.IN_PROGRESS, "Wäsche waschen", "Kleidung säubern");
        when(todoService.getTodo(todo.getId())).thenReturn(Optional.of(todo));

        TodoController todoController = new TodoController(todoService);

        //When
        Todo actual = todoController.getTodo(todo.getId());

        //Then
        assertThat(actual).isEqualTo(todo);
    }

}