package com.lihd.qqzone.service.impl;

import com.lihd.qqzone.dao.TopicDAO;
import com.lihd.qqzone.dao.UserBasicDAO;
import com.lihd.qqzone.pojo.Topic;
import com.lihd.qqzone.pojo.UserBasic;
import com.lihd.qqzone.service.UserBasicService;

import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/6 15:24
 */
public class UserBasicServiceImpl implements UserBasicService {

    private UserBasicDAO userBasicDAO;
    private TopicDAO topicDAO;

    @Override
    public UserBasic getUserAllInfoByLogin(String loginId, String pwd) {

        UserBasic userBasic = getUserBasicByLogin(loginId, pwd);
        if(userBasic != null){

            List<UserBasic> friendListById = getFriendListById(userBasic.getId());
            List<Topic> topicList = topicDAO.getTopicList(userBasic);
            userBasic.setFriendList(friendListById);
            userBasic.setTopicList(topicList);

            return userBasic;
        }
        return null;
    }

    public UserBasic getUserBasicByIdWithTopicList(Integer id){
        UserBasic userBasicById = getUserBasicById(id);
        if(userBasicById != null){
            List<Topic> topicList = topicDAO.getTopicList(userBasicById);
            userBasicById.setTopicList(topicList);
            return userBasicById;
        }

        return null;
    }

    @Override
    public UserBasic getUserBasicByLogin(String loginId, String pwd) {
        return userBasicDAO.getUserBasicByLogin(loginId, pwd);
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        return userBasicDAO.getUserBasicById(id);
    }

    @Override
    public List<UserBasic> getFriendListById(Integer id) {
        return userBasicDAO.getFriendListById(id);
    }
}
