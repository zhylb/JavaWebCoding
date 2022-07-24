package com.lihd.myssm.trans;

import com.lihd.myssm.basedao.ConnectionUtils;

import java.sql.SQLException;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/5 23:23
 */
public class TransactionManager {

    public static void startTransaction() throws SQLException {
        ConnectionUtils.getConnection().setAutoCommit(false);
    }

    public static void commit() throws SQLException {
        ConnectionUtils.getConnection().commit();
    }

    public static void rollback() throws SQLException{
        ConnectionUtils.getConnection().rollback();
    }

    public static void endTransaction() throws SQLException {
        ConnectionUtils.getConnection().setAutoCommit(true);
        ConnectionUtils.closeConnection();
    }


}
