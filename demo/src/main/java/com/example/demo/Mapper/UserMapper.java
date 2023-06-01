package com.example.demo.Mapper;

import com.example.demo.Model.T_User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    
    @Select("SELECT * FROM t_user WHERE id=#{id}")
    public T_User selectUserById(Integer id);

    @Select("SELECT * FROM t_user WHERE username=#{username}")
    public T_User selectUserByUsername(String username);

    @Insert("INSERT INTO t_user(username, password) values(#{username}, #{password})")
    public int insertUser(T_User user);

    @Update("UPDATE t_user SET password=#{password} WHERE id=#{id}")
    public int updatePassword(T_User user);

    @Delete("DELETE FROM t_user WHERE id=#{id}")
    public int deleteUser(Integer id);
}