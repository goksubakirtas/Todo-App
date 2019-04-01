package com.ToDoWebService.Todo.todo;
import com.ToDoWebService.Todo.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created on Feb, 2019
 *
 * @author Göksu Bakırtaş
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class TodoService {
    private final TodoRepository todoRepository;

    public Page<Todo> getTodoByStatus(Status statu, Pageable pageable){
        Page<Todo> todoStatu=todoRepository.findAllByStatu(statu, pageable);
        return todoStatu;
    }

    public Page<Todo> getAllJob(Pageable pageable){
        log.info("Get");
        return todoRepository.findAll(pageable);
    }

    public Todo getByIdJob(Long jobId){ //throws Exception {
        Todo toDo= todoRepository.findById(jobId).orElseThrow(()-> new JobNotFoundException("Not found"));
        log.info(toDo+" get by ıd");
        return toDo;
    }

    public Todo createJob(Todo todo){
        log.info(todo.getJobId()+". job created");
        todo.setStatu(Status.Todo);
        return todoRepository.save(todo);
    }

    public Todo updateJob(Long jobId, Todo todoRequest) {
        Todo todo = getByIdJob(jobId);
        todo.setJobText(todoRequest.getJobText());
        todo.setStatu(todoRequest.getStatu());
        log.info(todo.getJobId()+". job changed");
        return todoRepository.save(todo);

    }

    public void deleteJob(Long jobId){
        log.info(jobId +". job deleted");
        todoRepository.deleteById(jobId);
    }

    public void deleteAllJob(){
        log.info("All job deleted");
        todoRepository.deleteAll();
    }
}
