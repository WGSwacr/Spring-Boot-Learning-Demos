package com.example.demo.Dao;

import java.util.List;
import java.util.Map;

import com.example.demo.Model.T_User;

public interface UserDao {
    int addUser(T_User t_User);
    int updateUser(T_User t_User);
    int deleteUser(T_User t_User);
    T_User findUserById(Integer id);

    List<Map<String, Object>> listUser();
}