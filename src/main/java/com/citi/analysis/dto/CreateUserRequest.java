package com.citi.analysis.dto;

import lombok.Data;

@Data
public class CreateUserRequest {

    private String userId;
    private String name;
    private String email;
}
