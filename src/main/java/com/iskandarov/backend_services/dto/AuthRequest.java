package com.iskandarov.backend_services.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
