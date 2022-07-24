package com.lihd.book.service.impl;

import com.lihd.book.dao.UserDAO;
import com.lihd.book.pojo.User;
import com.lihd.book.service.UserService;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/7 16:13
 */
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Override
    public User login(String uname, String pwd) {
        User login = userDAO.login(uname, pwd);
        return login;
    }

    @Override
    public User getUserById(Integer id) {

        return userDAO.getUserById(id);
    }

    @Override
    public void register(User user) {
        userDAO.register(user);
    }

    @Override
    public User checkName(String uname) {
        return userDAO.checkName(uname);
    }
}
