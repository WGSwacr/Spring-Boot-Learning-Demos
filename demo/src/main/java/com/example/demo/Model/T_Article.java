package com.example.demo.Model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class T_Article {
    
    private Integer id;
    private String author;
    private String content;
    private String type;
    private Timestamp create_time;
    private Timestamp update_time;
}