package com.example.demo.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.Mapper.UserMapper;
import com.example.demo.Model.T_User;

@Repository
public class UserDaoImplement implements UserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserMapper userMapper;

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

    // @Override
    // public T_User findUserById(Integer id) {
    //     return jdbcTemplate.queryForObject("SELECT * FROM t_user WHERE id=?",
    //     new BeanPropertyRowMapper<T_User>(T_User.class), new Object[]{id});
    // }
    
    @Override
    public List<Map<String, Object>> listUser() {
        return jdbcTemplate.queryForList("SELECT * FROM t_user");
    }

    @Override
    public int login(T_User t_User) throws Exception {
        try {
            T_User auth_t_User = userMapper.selectUserByUsername(t_User.getUsername());
            if(auth_t_User==null) {
                return 2;
            } else {
                if(auth_t_User.getPassword() == t_User.getPassword()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        } catch(Exception e) {
            throw e;
        }
    }
}
