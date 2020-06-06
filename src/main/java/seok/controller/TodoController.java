package seok.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seok.model.Todo;
import seok.model.TodoResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {
    private final AtomicInteger counter = new AtomicInteger();

    @GetMapping("/todo")
    public Todo findTodo() {
        return new Todo(counter.incrementAndGet(), "코딩하기");
    }

    @PostMapping("/todo")
    public Todo registryTodo(@RequestParam String todoTitle) {
        return new Todo(counter.incrementAndGet(), todoTitle);
    }

    @PostMapping("/todo/response")
    public ResponseEntity<Todo> postRegistryTodo(@RequestParam String todoTitle) {
        return new ResponseEntity<>(new Todo(counter.incrementAndGet(), todoTitle), HttpStatus.CREATED);
    }

    @PostMapping("/todo/hateoas")
    public ResponseEntity<TodoResource> resourceResponseEntity(@RequestParam String todoTitle) {
        TodoResource todoResource = new TodoResource(todoTitle);
        todoResource.add(linkTo(methodOn(TodoController.class).resourceResponseEntity(todoTitle)).withSelfRel());
        return new ResponseEntity<>(todoResource, HttpStatus.OK);
    }
}
