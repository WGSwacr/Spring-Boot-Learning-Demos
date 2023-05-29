package com.example.demo.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class T_User {
    
    private Integer id;
    private String username;
    private String password;
}
