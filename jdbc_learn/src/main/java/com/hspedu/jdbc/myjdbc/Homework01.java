package com.hspedu.jdbc.myjdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Homework01 {
    public static void main(String[] args) throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File("D:\\datastructure_java\\jdbc_learn\\src\\main\\resources\\db.properties")));
        String username = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        Connection connection = DriverManager.getConnection(url,username,password);
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS news (id INT PRIMARY KEY AUTO_INCREMENT,content VARCHAR(100))");
        statement.executeUpdate("INSERT INTO news (content) values ('News value 01')");
        statement.executeUpdate("INSERT INTO news (content) values ('News value 02')");
        statement.executeUpdate("INSERT INTO news (content) values ('News value 03')");
        statement.executeUpdate("INSERT INTO news (content) values ('News value 04')");
        statement.executeUpdate("INSERT INTO news (content) values ('News value 05')");

        statement.close();
        connection.close();

    }

}
