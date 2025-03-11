package com.example.bills.Service.Impl;

import java.sql.Date;
import java.util.List;

import com.example.bills.Dao.BillsDao;
import com.example.bills.Dao.Impl.BillsDaoImpl;
import com.example.bills.Entity.Bills;
import com.example.bills.Service.BillsService;

public class BillsServiceImpl implements BillsService {
    BillsDao BillsDao;
    public BillsServiceImpl(){
        this.BillsDao = new BillsDaoImpl();
    }
     // 查询所有账单
    public List<Bills> findAll(){
        return BillsDao.findAll();
    };
    // 根据type id查询账单
    public List<Bills> findById(int type){
        return BillsDao.findById(type);
    };
    //根据时间查询账单
    public List<Bills> findByTime(Date time){
        return BillsDao.findByTime(time);
    };
    //根据时间段查询账单
    public List<Bills> findByTime(Date startTime,Date endTime){
        return BillsDao.findByTime(startTime,endTime);
    };
    // 添加账单
    public void add(Bills bills){
        BillsDao.add(bills);
    };
    // 修改账单
    public void update(Bills bills,int id){
        BillsDao.update(bills,id);
    };
    // 删除账单
    public void delete(int id){
        BillsDao.delete(id);
    };
}
