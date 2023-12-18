package com.hspedu.jdbc.myjdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class SelectJdbcTest {
    public static void main(String[] args) throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File("D:\\datastructure_java\\jdbc_learn\\src\\main\\resources\\db.properties")));
        String username = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM news";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt(1); //获取第一列数据
            String content = resultSet.getString(2);
            System.out.println(id + " " + content);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
