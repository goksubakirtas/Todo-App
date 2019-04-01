package com.ToDoWebService.Todo.todo;
import com.ToDoWebService.Todo.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created on Feb, 2019
 *
 * @author Göksu Bakırtaş
 */
@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/status/{status}")
    public Page<Todo> getTodoByStatus(@PathVariable(value = "status") Status status, Pageable pageable){
        Page<Todo> todoStatu=todoService.getTodoByStatus(status, pageable);
        return todoStatu;
    }

    @GetMapping
    public Page<Todo> getAllJob( Pageable pageable){//@PageableDefault(size = 10)
        final Page<Todo> todos=todoService.getAllJob(pageable);
        return todos;
    }

    @GetMapping("/{jobId}")
    public Todo getByIdJob(@PathVariable (value = "jobId") Long jobId){
        return todoService.getByIdJob(jobId);
    }

    @PostMapping
    public ResponseEntity<Todo> createJob(@Valid @RequestBody  Todo todo){
        todoService.createJob(todo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{jobId}")
    public ResponseEntity<Todo> updateJob(@PathVariable(value = "jobId") Long jobId, @Valid @RequestBody Todo todoRequest){
        todoService.updateJob(jobId, todoRequest);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{jobId}")
    public ResponseEntity<Void> deleteJob(@PathVariable(value = "jobId") Long jobId){
        todoService.deleteJob(jobId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllJob(){
        todoService.deleteAllJob();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
