package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Dao.UserDaoImplement;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Model.T_User;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class User {

    @Autowired
    private UserDaoImplement userDaoImplement;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/list")
    public String userList(ModelMap map) {
        List<Map<String, Object>> userList = userDaoImplement.listUser();
        map.addAttribute("userList", userList);
        map.addAttribute("flag", "list");
        return "user_list";
    }

    @GetMapping("/detail/{id}")
    public String userDetail(ModelMap map, @PathVariable Integer id) {
        T_User t_User = userMapper.selectUser(id);
        map.addAttribute("user", t_User);
        map.addAttribute("flag", "detail");
        return "user_detail";
    }

    @GetMapping("/add")
    public String addUser(ModelMap map) {
        map.addAttribute("flag", "add");
        return "user_add";
    }

    @PostMapping("/add")
    public String addUserDone(ModelMap map, String username, String password) {
        T_User t_User = T_User.builder().username(username).password(password).build();
        int success = userDaoImplement.addUser(t_User);
        map.addAttribute("success", success);
        map.addAttribute("flag", "add");
        return "user_add";
    }

    @GetMapping("/update/{id}")
    public String updateUser(ModelMap map, @PathVariable Integer id) {
        T_User t_User = userMapper.selectUser(id);
        map.addAttribute("user", t_User);
        map.addAttribute("flag", "update");
        return "user_update";
    }

    @PostMapping("/update/{id}")
    public String updateUserDone(ModelMap map, @PathVariable Integer id, String password) {
        T_User t_User = T_User.builder().id(id).password(password).build();
        int success = userDaoImplement.updateUser(t_User);
        T_User new_t_User = userMapper.selectUser(id);
        map.addAttribute("user", new_t_User);
        map.addAttribute("success", success);
        map.addAttribute("flag", "update");
        return "user_update";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(ModelMap map, @PathVariable Integer id) {
        T_User t_User = userMapper.selectUser(id);
        map.addAttribute("user", t_User);
        map.addAttribute("flag", "delete");
        return "user_delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteUserDone(ModelMap map, @PathVariable Integer id) {
        T_User new_t_User = userMapper.selectUser(id);
        int success = userDaoImplement.deleteUser(T_User.builder().id(id).build());
        map.addAttribute("user", new_t_User);
        map.addAttribute("success", success);
        map.addAttribute("flag", "delete");
        return "user_delete";
    }
}