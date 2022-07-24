package com.lihd.myssm.basedao;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/31 9:09
 */
public abstract class BaseDAO<T> {

    private Class<T> clazz;


    //在代码块中赋予初值
    {
        Type type = this.getClass().getGenericSuperclass();
        ParameterizedType parType = (ParameterizedType) type;
        Type[] actualTypeArguments = parType.getActualTypeArguments();
        clazz = (Class<T>) actualTypeArguments[0];
    }



    public  <E> E valueQuery(String sql,Object...args) {
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                E e = (E) rs.getObject(1);
                return e;
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("DAO层出现了错误");
        } finally {
            close(ps);
        }
        return null;

    }




    public int updateQuery(String sql,Object...args){
        //flag为真 需要返回自增列的值
        boolean flag = sql.trim().toLowerCase().startsWith("insert");
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();


            if(flag)
                ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            else
                ps = conn.prepareStatement(sql);


            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            int i = ps.executeUpdate();


            if(flag){
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    long aLong = rs.getLong(1);
                    return (int) aLong;
                }

            }

            return i;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("DAO层出现了错误");
        } finally {
            close(ps);
        }
    }




    public  T queryForOne( String sql, Object ... args){
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            //1 获取connection
            conn = ConnectionUtils.getConnection();
            //2 根据connection预编译sql命令，返回preparedStatement对象
            ps = conn.prepareStatement(sql);
            //3 ps对象设置参数
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            if(rs.next()){
                T t = clazz.newInstance();

                for (int i = 1; i <= columnCount; i++) {
                    Object value = rs.getObject(i);

                    String columnLabel = rsmd.getColumnLabel(i);
                    Field field = clazz.getDeclaredField(columnLabel);
                    String name = field.getType().getName();
                    if (isMyClass(name)) {
                        Class<?> myClazz = Class.forName(name);
                        Object myObj = myClazz.newInstance();
                        Field id = myClazz.getDeclaredField("id");
                        id.setAccessible(true);
                        id.set(myObj,value);
                        value = myObj;
                    }


                    field.setAccessible(true);
                    field.set(t,value);
                }

                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("DAO层出现了错误");
        } finally {
            close(ps,rs);
        }


        return null;
    }

    public boolean isMyClass(String name){
        return name.startsWith("com.lihd");
    }


    public  List<T> queryForList(String sql, Object ... args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<>();
        try {
            //1 获取connection
            conn = ConnectionUtils.getConnection();
            //2 根据connection预编译sql命令，返回preparedStatement对象
            ps = conn.prepareStatement(sql);
            //3 ps对象设置参数
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while (rs.next()){
                T t =  clazz.newInstance();

                for (int i = 1; i <= columnCount; i++) {
                    Object value = rs.getObject(i);


                    String columnLabel = rsmd.getColumnLabel(i);

                    Field field = clazz.getDeclaredField(columnLabel);
                    String name = field.getType().getName();
                    if (isMyClass(name)) {
                        Class<?> myClazz = Class.forName(name);
                        Object myObj = myClazz.newInstance();
                        Field id = myClazz.getDeclaredField("id");
                        id.setAccessible(true);
                        id.set(myObj,value);
                        value = myObj;
                    }


                    field.setAccessible(true);
                    field.set(t,value);
                }

                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("DAO层出现了错误");
        } finally {
            close(ps,rs);
        }

    }





    public static void close(Statement statement){
        close(statement,null);
    }


    public static void close(Statement statement, ResultSet rs){
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (rs != null) {

                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
