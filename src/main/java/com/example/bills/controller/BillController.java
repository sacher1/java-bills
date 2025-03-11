package com.example.bills.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bills.Entity.Bills;
import com.example.bills.Service.BillsService;
import com.example.bills.Service.Impl.BillsServiceImpl;

@RestController
@RequestMapping("/api")
public class BillController {
    private BillsService BillsService;

    public BillController(){
        BillsService = new BillsServiceImpl();//Controller调用Service层，实例化时使用service实现类
    }
    // 查询用户所有账单
    @GetMapping("/bills")
    public List<Bills> findAll() {
        return BillsService.findAll();
    }
    //根据类型查询账单
    @GetMapping("/bill/type/{type}")
    public List<Bills> findById(@PathVariable int type){
        return BillsService.findById(type);
    }
    //根据时间查询账单
    @GetMapping("/bill/time/{time}")
    public List<Bills> findByTime(@PathVariable Date time){
        return BillsService.findByTime(time);
    }
    //根据时间范围查询账单
    @GetMapping("/bill/time/{startTime}/{endTime}")
    public List<Bills> findByTime(@PathVariable Date startTime,@PathVariable Date endTime){
        return BillsService.findByTime(startTime,endTime);
    }
    //添加账单
    @PostMapping("/bill")
    public void add(@RequestBody Bills bills){
        BillsService.add(bills);
    }
    //修改账单
    @PutMapping("/bill/{id}")
    public void update(@RequestBody Bills bills,@PathVariable int id){
        BillsService.update(bills, id);
    }
    //删除账单
    @DeleteMapping("/bill/{id}")
    public void delete(@PathVariable int id){
        BillsService.delete(id);
    }
}
