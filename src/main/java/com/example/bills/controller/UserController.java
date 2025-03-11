package com.example.bills.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bills.Entity.User;
import com.example.bills.Service.UserService;
import com.example.bills.Service.Impl.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserService UserService;

    public UserController(){
        UserService = new UserServiceImpl();//Controller调用Service层，实例化时使用service实现类
    }
    //添加用户
    @PostMapping("/user")
    public void insert(@RequestBody User user){
        UserService.insert(user);
    }
    //验证用户信息
    @PostMapping("/user/login")
    public User login(@RequestBody User user) {
        return UserService.login(user.getLoginName(), user.getPassword());
    }
    //修改用户信息
    @PutMapping("/user/{id}")
    public void update(@RequestBody User user,@PathVariable int id){
        UserService.update(user, id);
    }
    // 删除用户
    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable int id){
        UserService.delete(id);
    }
    // 查询所有用户
    @GetMapping("/users")//yes
    public List<User> selectAll(){
        return UserService.selectAll();
    }
}
