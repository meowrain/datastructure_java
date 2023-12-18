package com.hspedu.jdbc.myjdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc01 {
    public static void main(String[] args) throws SQLException {

        // 1. 注册驱动
        Driver driver = new Driver();
        String url = "jdbc:mysql://100.113.199.61:3306/hsp_db02";
        //用户名密码放在Properties对象中
        Properties properties = new Properties();
        properties.setProperty("user","root"); //用户
        properties.setProperty("password","123456"); //密码

        // 2.获取连接
        Connection connection = driver.connect(url,properties);

        // 3.执行sql
        String sql = "INSERT INTO actor values (null,'meowrain','男','2004-12-12','119225')";
        Statement statement = connection.createStatement();
        int rows = statement.executeUpdate(sql);
        System.out.println(rows > 0 ? "成功" : "失败");
        statement.close();

        //4.断开链接
        connection.close();


    }
}