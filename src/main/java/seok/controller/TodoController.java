package seok.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seok.model.Todo;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {
    private final AtomicInteger counter = new AtomicInteger();

    @RequestMapping("/todo")
    public Todo todo(){
        return new Todo(counter.incrementAndGet(), "코딩하기");
    }
}
