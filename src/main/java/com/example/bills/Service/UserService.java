package com.example.bills.Service;

import java.util.List;

import com.example.bills.Entity.User;

public interface UserService {
     // 添加用户
    public void insert(User user);
    //用户验证
    public User login(String loginName,String password);
    //修改用户信息
    public void update(User user,int id);
    // 删除用户
    public void delete(int id);
    // 查询所有用户
    public List<User> selectAll();
}
