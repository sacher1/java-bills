package com.example.bills.Entity;
import java.sql.Date;

public class Bills {
    private String title;
    private String remark;
    private double money;
    private Date time;
    private int type;
    private int id;
    public void setTitle(String title) {
        this.title = title;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public void setMoney(double money) {
        this.money = money;
    }
    public void setTime(Date time) {
        this.time = time;
    }
    public void setType(int type) {
        this.type = type;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    public String getRemark() {
        return remark;
    }
    public double getMoney() {
        return money;
    }
    public Date getTime() {
        return time;
    }
    public int getType() {
        return type;
    }
    public int getId() {
        return id;
    }
    
    
    @Override
    public String toString() {
        return "Bills [title=" + title + ", remark=" + remark + ", money=" + money + ", time=" + time + ", type=" + type
                +  ", id=" + id + "]";
    }
    public Bills() {
    }
    public Bills(String title, String remark, double money, Date time, int type,int userId) {
        this.title = title;
        this.remark = remark;
        this.money = money;
        this.time = time;
        this.type = type;
    }
}
