package com.empmgmt.dataservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return Objects.equals(this.getTaskId(), task.getTaskId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getTaskId());
    }
}
