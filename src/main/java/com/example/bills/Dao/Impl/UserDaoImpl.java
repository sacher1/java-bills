package com.example.bills.Dao.Impl;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.bills.Dao.UserDao;
import com.example.bills.Entity.User;
import com.example.bills.DataBase.DataBaseConnection;

public class UserDaoImpl implements UserDao {
    private Connection conn;
    public UserDaoImpl(){
        this.conn = DataBaseConnection.getConnection();
    }
    // 添加用户
    public void insert(User user){
        String sql = "insert into user(username,loginname,pwd,sex) values(?,?,?,?)";
        try(
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getLoginName());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getSex());

            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    //验证
    public User login(String loginName,String password){
         // 使用预编译SQL语句，防止SQL注入攻击
    String sql = "select * from user where loginname=? and pwd=?";
    try (
        PreparedStatement ps = conn.prepareStatement(sql);
    ) {
        ps.setString(1, loginName);
        ps.setString(2, password);

        // 执行查询
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUserName(rs.getString("username"));
            user.setLoginName(rs.getString("loginname"));
            user.setPassword(rs.getString("pwd"));
            user.setSex(rs.getString("sex"));
            return user;
        }
    } catch (SQLException e) {
        return null;
    }
        return null;
    }
    //修改用户信息
    public void update(User user,int id){
        String sql = "update user set username=?,pwd=?,sex=? where id=?";
        try(
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSex());
            ps.setInt(4, id);

            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 删除用户
    public void delete(int id){
        String sql = "delete from user where id=?";
        try (
            PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 查询所有用户
    public List<User> selectAll(){
        String sql = "select * from user";
        List<User> users = new ArrayList<>();
        try(
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        ){
            while (rs.next()) {
                User user = new User();
                user.setUserName(rs.getString("username"));
                user.setLoginName(rs.getString("loginname"));
                user.setPassword(rs.getString("pwd"));
                user.setSex(rs.getString("sex"));
                user.setId(rs.getInt("id"));
                users.add(user);
            }

            return users;
        }catch (Exception e) {
            return null;
        }
    }
}