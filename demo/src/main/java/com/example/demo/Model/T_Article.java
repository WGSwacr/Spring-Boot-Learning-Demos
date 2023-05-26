package com.example.demo.Model;

import java.sql.Timestamp;

public class T_Article {
    
    private Integer id;
    private String author;
    private String content;
    private String type;
    private Timestamp create_time;
    private Timestamp update_time;

    public T_Article(int id, String author, String content, String type, Timestamp create_time, Timestamp update_time) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.type = type;
        this.create_time = create_time;
        this.update_time = update_time;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCreateTime(Timestamp create_time) {
        this.create_time = create_time;
    }

    public void setUpdateTime(Timestamp update_time) {
        this.update_time = update_time;
    }

    public Integer getId() {
        return this.id;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getContent() {
        return this.content;
    }

    public String getType() {
        return this.type;
    }

    public Timestamp getCreateTime() {
        return this.create_time;
    }

    public Timestamp getUpdateTime() {
        return this.update_time;
    }

    public String toString() {
        return "{id=" + this.id + ", author=" + this.author + ", content=" + this.content + ", type=" + this.type
        + ", create_time=" + this.create_time + ", update_time=" + this.update_time + "}";
    }
}
