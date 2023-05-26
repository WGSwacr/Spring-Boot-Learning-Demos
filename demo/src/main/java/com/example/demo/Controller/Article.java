package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Timestamp;

import org.springframework.stereotype.Controller;

import com.example.demo.Model.T_Article;
import org.springframework.ui.Model;

@Controller
public class Article {
    
    @GetMapping("/article")
    public String article(Model model) {
        Timestamp t1 = new Timestamp(10000);
        Timestamp t2 = new Timestamp(300000);
        T_Article t_article = new T_Article(1, "am", "123", "none", t1, t2);
        model.addAttribute("t_article", t_article);
        return "article";
    }
}
