package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldAddTodo(){
        Todo todo = new Todo(TodoStatus.IN_PROGRESS, "Wäsche waschen", "Kleidung säubern");
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/api/kanban", todo, Void.class);

        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void shouldAddAndRemoveTodo(){
        Todo todo = new Todo(TodoStatus.OPEN, "Wäsche waschen", "Kleidung säubern");
        restTemplate.postForEntity("/api/kanban", todo, Void.class);
        restTemplate.delete("/api/kanban/" + todo.getId(), Void.class);

        ResponseEntity<Todo[]> responseEntity1 = restTemplate.getForEntity("/api/kanban", Todo[].class);

        Assertions.assertThat(responseEntity1.getBody()).isEmpty();
    }

    @Test
    void shouldAddAndNotRemoveTodo(){
        Todo todo = new Todo(TodoStatus.OPEN, "Wäsche waschen", "Kleidung säubern" );
        restTemplate.postForEntity("/api/kanban", todo, Void.class);
        restTemplate.delete("/api/kanban/" + "123", Void.class);

        ResponseEntity<Todo[]> responseEntity1 = restTemplate.getForEntity("/api/kanban", Todo[].class);

        Assertions.assertThat(responseEntity1.getBody()).isNotEmpty();
    }


}