package com.hspedu.jdbc.myjdbc;

import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConn {

    public void connect01() throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql://100.113.199.61:3306/hsp_db02";
        //用户名密码放在Properties对象中
        Properties properties = new Properties();
        properties.setProperty("user", "root"); //用户
        properties.setProperty("password", "123456"); //密码
        // 2.获取连接
        Connection connection = driver.connect(url, properties);
        System.out.println(connection);
        connection.close();
    }

    public void connect02() throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql://100.113.199.61:3306/hsp_db02";
        //用户名密码放在Properties对象中
        Properties properties = new Properties();
        properties.setProperty("user", "root"); //用户
        properties.setProperty("password", "123456"); //密码
        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(url,properties);
        System.out.println(connection);
        connection.close();
    }

    public void connect03() throws SQLException {

        String url = "jdbc:mysql://100.113.199.61:3306/hsp_db02";
        //用户名密码放在Properties对象中
        Properties properties = new Properties();
        properties.setProperty("user", "root"); //用户
        properties.setProperty("password", "123456"); //密码
        Connection connection = DriverManager.getConnection(url,properties);
        System.out.println(connection);
        connection.close();
    }

    public void connect04() throws SQLException, IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\datastructure_java\\jdbc_learn\\src\\main\\resources\\db.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println(connection);
        connection.close();
    }

    public static void main(String[] args) throws SQLException, IOException {
        JdbcConn conn = new JdbcConn();
        conn.connect02();
        conn.connect03();
        conn.connect04();
    }


}
