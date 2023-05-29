package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.Dao.UserDaoImplement;

import java.util.List;
import java.util.Map;

@Controller
public class User {

    @Autowired
    private UserDaoImplement userDaoImplement;

    @GetMapping("/user")
    public String getUsers(ModelMap map) {
        
        List<Map<String, Object>> userList = userDaoImplement.listUser();
        map.addAttribute("users", userList);
        return "user";
    }
}