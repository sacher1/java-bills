package com.example.bills.Dao.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.bills.Dao.BillsDao;
import com.example.bills.DataBase.DataBaseConnection;
import com.example.bills.Entity.Bills;

public class BillsDaoImpl implements BillsDao{
    private Connection conn;
    public BillsDaoImpl(){
        this.conn = DataBaseConnection.getConnection();
    }
    // 查询所有账单
    public List<Bills> findAll(){
        String sql = "select * from bills ";
        List<Bills> bills = new ArrayList<>();
        try(
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Bills bill = new Bills();
                    bill.setTitle(rs.getString("title"));
                    bill.setRemark(rs.getString("remark"));
                    bill.setMoney(rs.getDouble("price"));
                    bill.setTime(rs.getDate("billtime"));
                    bill.setType(rs.getInt("typeid"));
                    bill.setId(rs.getInt("id"));
                    bills.add(bill);
                }
            }
            return bills;
        } catch (Exception e) {
            return null;
        }
    }
    // 根据type id查询账单
    public List<Bills> findById(int type){
        String sql = "select * from bills where typeid=?";
        List<Bills> bills = new ArrayList<>();
        try(
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, type);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Bills bill = new Bills();
                    bill.setTitle(rs.getString("title"));
                    bill.setRemark(rs.getString("remark"));
                    bill.setMoney(rs.getDouble("price"));
                    bill.setTime(rs.getDate("billtime"));
                    bill.setType(rs.getInt("typeid"));
                    bill.setId(rs.getInt("id"));
                    bills.add(bill);
                }
            }
            return bills;
        } catch (Exception e) {
            throw new RuntimeException("查询账单时发生错误: " + e.getMessage(), e);

        }
    }
    //根据时间查询账单
    public List<Bills> findByTime(Date time){
        String sql = "select * from bills where billtime=? ";
        List<Bills> bills = new ArrayList<>();
        try(
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setDate(1, time);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Bills bill = new Bills();
                    bill.setTitle(rs.getString("title"));
                    bill.setRemark(rs.getString("remark"));
                    bill.setMoney(rs.getDouble("price"));
                    bill.setTime(rs.getDate("billtime"));
                    bill.setType(rs.getInt("typeid"));
                    bill.setId(rs.getInt("id"));
                    bills.add(bill);
                }
            }
            return bills;
        } catch (Exception e) {
            return null;
        }
    }
    //根据时间段查询账单
    public List<Bills> findByTime(Date startTime,Date endTime){
        String sql = "select * from bills where billtime between ? and ? ";
        List<Bills> bills = new ArrayList<>();
        try (
            PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setDate(1, startTime);
            ps.setDate(2, endTime);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Bills bill = new Bills();
                    bill.setTitle(rs.getString("title"));
                    bill.setRemark(rs.getString("remark"));
                    bill.setMoney(rs.getDouble("price"));
                    bill.setTime(rs.getDate("billtime"));
                    bill.setType(rs.getInt("typeid"));
                    bill.setId(rs.getInt("id"));
                    bills.add(bill);
                }
            }
            return bills;
        } catch (Exception e) {
            return null;
        }

    }
    // 添加账单
    public void add(Bills bills){
        String sql = "insert into bills(title,remark,price,billtime,typeid) values(?,?,?,?,?)";
        try(
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, bills.getTitle());
            ps.setString(2, bills.getRemark());
            ps.setDouble(3, bills.getMoney());
            ps.setDate(4, bills.getTime());
            ps.setInt(5, bills.getType());
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    // 修改账单
    public void update(Bills bills,int id){
        String sql = "update bills set title=?,remark=?,price=?,billtime=?,typeid=? where id=?";
        try(
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, bills.getTitle());
            ps.setString(2, bills.getRemark());
            ps.setDouble(3, bills.getMoney());
            ps.setDate(4, bills.getTime());
            ps.setInt(5, bills.getType());
            ps.setInt(6, id);
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    // 删除账单
    public void delete(int id){
        String sql = "delete from bills where id=?";
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
}
