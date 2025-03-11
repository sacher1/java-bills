package com.example.bills.Service.Impl;

import java.util.List;

import com.example.bills.Dao.UserDao;
import com.example.bills.Dao.Impl.UserDaoImpl;
import com.example.bills.Entity.User;
import com.example.bills.Service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao;
    public UserServiceImpl(){
        this.userDao = new UserDaoImpl();
    }
    @Override
    public void insert(User user) {
        userDao.insert(user);
    }
    @Override
    //用户验证
    public User login(String loginName,String password){
        return userDao.login(loginName,password);
    };
    @Override
    public void update(User user,int id) {
        userDao.update(user,id);
    }
    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }
}
