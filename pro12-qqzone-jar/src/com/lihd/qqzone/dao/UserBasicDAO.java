package com.lihd.qqzone.dao;

import com.lihd.qqzone.pojo.UserBasic;

import java.util.List;

public interface UserBasicDAO {
    /**
     * 根据用户名和密码获取UserBasic对象
     * @Author lihd
     * @Date 12:51 2022/4/6
     * @Param [loginId, pwd]
     * @return com.lihd.qqzone.pojo.UserBasic
     **/
    UserBasic getUserBasicByLogin(String loginId,String pwd);


    UserBasic getUserBasicById(Integer id);

    /**
     * @Author lihd
     * @Description //TODO LiHaoda
     * @Date 12:56 2022/4/6
     * @Param [id]
     * @return java.util.List<com.lihd.qqzone.pojo.UserBasic>
     **/
    List<UserBasic> getFriendListById(Integer id);














}
