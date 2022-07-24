package com.lihd.qqzone.service;

import com.lihd.qqzone.pojo.UserBasic;

import java.util.List;

public interface UserBasicService {

    UserBasic getUserAllInfoByLogin(String loginId, String pwd);

    UserBasic getUserBasicByLogin(String loginId, String pwd);

    UserBasic getUserBasicById(Integer id);
    UserBasic getUserBasicByIdWithTopicList(Integer id);

    List<UserBasic> getFriendListById(Integer id);
}
