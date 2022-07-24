package com.lihd.myssm.basedao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/5 23:04
 */
public class ConnectionUtils {
    //目前使用静态方式实现 以后进行改变
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();



    private static Connection createConnection(){
        try {
            String user = "root";
            String password = "abc123";
            String url = "jdbc:mysql://localhost:13306/test";
            String driverClass = "com.mysql.jdbc.Driver";
            //3 注册驱动
            Class.forName(driverClass);
            //4 获取connection
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Connection getConnection(){

        Connection connection = threadLocal.get();
        if (connection == null) {
            connection = createConnection();
            threadLocal.set(connection);
        }

        return connection;
    }


    public static void closeConnection(){
        Connection connection = threadLocal.get();
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            threadLocal.remove();
        }
    }



}
