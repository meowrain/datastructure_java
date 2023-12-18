package com.hspedu.jdbc.myjdbc;

public class MysqlJdbcImpl implements JdbcInterface {
    @Override
    public Object getConnection() {

        System.out.println("得到mysql的连接");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("crud");
    }

    @Override
    public void close() {
        System.out.println("closed");
    }
}
