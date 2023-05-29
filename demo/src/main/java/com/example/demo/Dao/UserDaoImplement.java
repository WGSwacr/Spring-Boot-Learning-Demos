package com.example.demo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.Model.T_User;

public class UserDaoImplement implements UserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addUser(T_User t_User) {
        return jdbcTemplate.update("INSERT INTO t_user(username, password) values(?, ?)",
        t_User.getUsername(), t_User.getPassword());
    }

    @Override
    public int updateUser(T_User t_User) {
        return jdbcTemplate.update("UPDATE t_user SET username=?, password=? WHERE id=?",
        t_User.getUsername(), t_User.getPassword(), t_User.getId());
    }

    @Override
    public int deleteUser(T_User t_User) {
        return jdbcTemplate.update("DELETE FROM t_user WHERE id=?",
        t_User.getId());
    }

    @Override
    public T_User findUserById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM t_user WHERE id=?",
        new Object[]{id}, new BeanPropertyRowMapper<T_User>(T_User.class));
    }
    
}
