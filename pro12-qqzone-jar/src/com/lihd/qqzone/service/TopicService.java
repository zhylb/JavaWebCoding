package com.lihd.qqzone.service;

import com.lihd.qqzone.pojo.Topic;
import com.lihd.qqzone.pojo.UserBasic;

import java.util.List;

public interface TopicService {


    List<Topic> getTopicListAllInfo(UserBasic userBasic);


    List<Topic> getTopicList(UserBasic userBasic);


    Topic getTopicById(Integer id);
    Topic getTopicAllInfoById(Integer id);

    void addTopic(Topic topic);

    void deleteTopicById(Integer id);
}
