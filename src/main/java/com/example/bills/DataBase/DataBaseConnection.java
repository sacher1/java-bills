package com.example.bills.DataBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//数据库的连接
/**
 * 数据库连接类，用于初始化和提供数据库连接。
 */
public class DataBaseConnection {
     // 静态变量，保存数据库连接对象
    private static Connection conn ;
    /**
     * 静态代码块，用于在类加载时初始化数据库连接。
     */
        static{
            try {
                 // 创建Properties对象，用于读取配置文件
                Properties prop = new Properties();
                // 从指定路径读取配置文件 application.properties
                prop.load(new FileInputStream("D:\\Java\\code\\bills\\src\\main\\resources\\application.properties"));//读取配置文件,文件要放在根目录
                // 加载数据库驱动类
                Class.forName(prop.getProperty("spring.datasource.driver-class-name"));
                 // 使用配置文件中的信息建立数据库连接
                conn = DriverManager.getConnection(
                    prop.getProperty("spring.datasource.url"),
                    prop.getProperty("spring.datasource.username"),
                    prop.getProperty("spring.datasource.password")
                );
            } catch (ClassNotFoundException | SQLException e) {
                // 捕获数据库驱动类未找到异常  捕获数据库连接失败异常
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                // 捕获配置文件未找到异常
                e.printStackTrace();
            } catch (IOException e) {
                // 捕获读取配置文件时的IO异常
                e.printStackTrace();
            }

        }
    public static Connection getConnection(){
        return conn;
    }
}
