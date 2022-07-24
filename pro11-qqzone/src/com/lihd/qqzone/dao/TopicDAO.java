package com.lihd.qqzone.dao;

import com.lihd.qqzone.pojo.Topic;
import com.lihd.qqzone.pojo.UserBasic;

import java.util.List;

public interface TopicDAO {

    List<Topic> getTopicList(UserBasic userBasic);

    Topic getTopicById(Integer id);

    void addTopic(Topic topic);

    void deleteTopicById(Integer id);




}
