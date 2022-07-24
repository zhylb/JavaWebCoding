package com.lihd.book.service;

import com.lihd.book.pojo.User;

public interface UserService {
    User login(String uname,String pwd);
    User getUserById(Integer id);
    void register(User user);
    User checkName(String uname);
}
