package com.lihd.myssm.basedao;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/5 23:04
 */
public class ConnectionUtils {
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal();
    private static String USER;
    private static String PASSWORD;
    private static String URL;
    private static String DRIVER;
    private static DataSource dataSource;





    public ConnectionUtils() {
    }

    static {
        InputStream is = ConnectionUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties properties = new Properties();

        try {
            properties.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        is = ConnectionUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        properties = new Properties();

        try {
            properties.load(is);
            USER = properties.getProperty("user");
            PASSWORD = properties.getProperty("password");
            URL = properties.getProperty("url");
            DRIVER = properties.getProperty("driver");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Connection createConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Connection createConnectionByMe() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Connection getConnection() {
        Connection connection = (Connection)threadLocal.get();
        if (connection == null) {
            connection = createConnection();
            threadLocal.set(connection);
        }

        return connection;
    }

    public static void closeConnection() {
        Connection connection = (Connection)threadLocal.get();
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
