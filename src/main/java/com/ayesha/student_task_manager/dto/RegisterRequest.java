package com.ayesha.student_task_manager.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
}