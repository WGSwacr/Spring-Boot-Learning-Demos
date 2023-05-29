package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

// import java.sql.Timestamp;

// import com.example.demo.Model.T_Article;

@Controller
public class Article {
    
    @GetMapping("/article")
    public String article(Model model) {
        
        return "article";
    }
}
