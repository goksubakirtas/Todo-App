package com.ToDoWebService.Todo.todo;

/**
 * Created on Mar, 2019
 *
 * @author Göksu Bakırtaş
 */
public class JobNotFoundException extends RuntimeException {

    public JobNotFoundException(String exception) {
        super(exception);
    }
}
