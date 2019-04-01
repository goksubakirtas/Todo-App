package com.ToDoWebService.Todo.todo;

import com.ToDoWebService.Todo.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created on Feb, 2019
 *
 * @author Göksu Bakırtaş
 */

@Repository
public interface TodoRepository extends PagingAndSortingRepository<Todo,Long> {
    Page<Todo> findAll(Pageable pageable);
    Page<Todo> findAllByStatu(Status statu, Pageable pageable);
    Optional<Todo> findById(Long jobId);
    Todo save(Todo todo);
    void deleteById(Long jobId);
    void deleteAll();
}

