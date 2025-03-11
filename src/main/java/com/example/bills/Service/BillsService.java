package com.example.bills.Service;

import java.sql.Date;
import java.util.List;

import com.example.bills.Entity.Bills;

public interface BillsService {
    // 查询所有账单
    public List<Bills> findAll();
    // 根据type id查询账单
    public List<Bills> findById(int type);
    //根据时间查询账单
    public List<Bills> findByTime(Date time);
    // 根据时间段查询账单
    public List<Bills> findByTime(Date startTime,Date endTime);
    // 添加账单
    public void add(Bills bills);
    // 修改账单
    public void update(Bills bills,int id);
    // 删除账单
    public void delete(int id);
}
