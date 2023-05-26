package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class User {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/user")
    @ResponseBody
    /*
    * List 里的对象是Map对象，而Map对象是
    * 由一个String类型的键和Object类型的值组成
    * */
    public List<Map<String,Object>> getUsers(){
    String sql="select * from t_user";//SQL查询语句
    List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
    return list;
    }
}