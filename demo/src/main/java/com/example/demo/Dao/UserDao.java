package com.example.demo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import com.example.demo.Model.T_User;

@Repository
public class UserDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public T_User getUserById(int id) {
        String sql = "select * from t_user where id = ?";
        List<T_User> list = jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper(T_User.class));
        if(list != null && list.size() > 0) {
            return list.get(id);
        } else {
            return null;
        }
    }
    
    public List<T_User> getUserList() {
        String sql = "select * from t_user";
        List<T_User> list = jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper(T_User.class));
        if(list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    public int add(T_User user) {
        return jdbcTemplate.update("insert into t_user(username, password) values(?, ?)",
                user.getUsername(),user.getPassword(), new Date());
    }

    public int update(int id, T_User user) {
        return jdbcTemplate.update("UPDATE t_user SET username = ? , password = ? WHERE id=?",
                user.getUsername(),user.getPassword(), id);
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE from t_user where id = ? ",id);
    }
}