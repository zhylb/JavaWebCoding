package com.lihd.book.dao;

import com.lihd.book.pojo.User;

public interface UserDAO {

    User login(String uname,String pwd);


    User getUserById(Integer id);

    User checkName(String uname);


    void register(User user);
}
