package com.ToDoWebService.Todo.todo;

import com.ToDoWebService.Todo.Status;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created on Feb, 2019
 *
 * @author Göksu Bakırtaş
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@RequiredArgsConstructor
@Getter
@Setter
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jobId")
    private Long jobId;


    @NotBlank(message = "This text isn't empty")
    @Column(name = "jobText")
    private String jobText;

   @Column(name = "statu",nullable = false)
   @Enumerated(EnumType.STRING)
    private Status statu;

    @Column(name = "createdDate", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;


    @Column(name = "modifiedDate",nullable = false)
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
