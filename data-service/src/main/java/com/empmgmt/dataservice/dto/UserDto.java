package com.empmgmt.dataservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long userId;
    private String fullName;
    private String userName;
    private String password;
}
