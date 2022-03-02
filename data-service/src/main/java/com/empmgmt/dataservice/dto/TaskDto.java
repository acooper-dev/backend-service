package com.empmgmt.dataservice.dto;

import com.empmgmt.dataservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private long taskId;
    private String description;
    private String status;
    private User User;
}
