package com.example.bills.Entity;

public class User {
    private String userName;
    private String loginName;
    private String password;
    private String sex;
    private int id;
    
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getLoginName() {
        return loginName;
    }
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public User(String userName, String loginName, String password, String sex) {
        this.userName = userName;
        this.loginName = loginName;
        this.password = password;
        this.sex = sex;
    }
    public User() {
    }
    @Override
    public String toString() {
        return "User [userName=" + userName + ", loginName=" + loginName + ", password=" + password + ", sex=" + sex
                + ", id=" + id + "]";
    }

    

}
