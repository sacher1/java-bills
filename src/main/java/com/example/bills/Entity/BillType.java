package com.example.bills.Entity;

public class BillType {
    private String name;
    private int id;

    public BillType (){

    }
    // 构造方法
    public BillType(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "类型=" + name + ", id=" + id;
    }
}
