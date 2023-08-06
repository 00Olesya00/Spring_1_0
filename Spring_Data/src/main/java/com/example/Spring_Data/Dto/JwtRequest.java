package com.example.Spring_Data.Dto;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
}
