package com.empmgmt.dataservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private long taskId;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private String status;

    @Column(name = "create_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
}
