package com.lihd.book.dao.impl;

import com.lihd.book.dao.UserDAO;
import com.lihd.book.pojo.User;
import com.lihd.myssm.basedao.BaseDAO;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/7 16:11
 */
public class UserDAOImpl extends BaseDAO<User> implements UserDAO {
    @Override
    public User login(String uname, String pwd) {
        String sql = "select * from t_user where uname = ? and pwd = ?";
        return super.queryForOne(sql,uname,pwd);
    }

    @Override
    public User getUserById(Integer id) {

        String sql = "select * from t_user where id = ?";

        return queryForOne(sql,id);
    }

    @Override
    public User checkName(String uname) {
        String sql = "select * from t_user where uname = ?";
        return queryForOne(sql,uname);
    }

    @Override
    public void register(User user) {
        int r = (int) (Math.random() * 20) + 1;
        String sql = "insert into t_user values(0,?,?,?,0,?)";
        updateQuery(sql,user.getUname(),user.getPwd(),user.getEmail(),r);
    }
}
