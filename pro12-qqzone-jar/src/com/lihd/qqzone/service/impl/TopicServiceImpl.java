package com.lihd.qqzone.service.impl;

import com.lihd.qqzone.dao.TopicDAO;
import com.lihd.qqzone.dao.UserBasicDAO;
import com.lihd.qqzone.pojo.Reply;
import com.lihd.qqzone.pojo.Topic;
import com.lihd.qqzone.pojo.UserBasic;
import com.lihd.qqzone.service.ReplyService;
import com.lihd.qqzone.service.TopicService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/6 15:23
 */
public class TopicServiceImpl implements TopicService {

    private TopicDAO topicDAO;
    private ReplyService replyService;
    private UserBasicDAO userBasicDAO;

    @Override
    public List<Topic> getTopicListAllInfo(UserBasic userBasic) {

        return null;
    }

    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return topicDAO.getTopicList(userBasic);
    }

    @Override
    public Topic getTopicById(Integer id) {
        return null;
    }

    @Override
    public Topic getTopicAllInfoById(Integer id) {

        Topic topic = topicDAO.getTopicById(id);

        List<Reply> replyListByTopic = replyService.getReplyListByTopic(topic);
        List<Reply> list = new ArrayList<>(replyListByTopic.size());
        for (int i = 0; i < replyListByTopic.size(); i++) {
            Reply reply = replyListByTopic.get(i);

            Reply replyAllInfoById = replyService.getReplyAllInfoById(reply.getId());

            list.add(replyAllInfoById);
        }

        UserBasic userBasicById = userBasicDAO.getUserBasicById(topic.getAuthor().getId());
        topic.setAuthor(userBasicById);


        topic.setReplyList(list);

        return topic;
    }

    @Override
    public void addTopic(Topic topic) {
        topicDAO.addTopic(topic);
    }

    @Override
    public void deleteTopicById(Integer id) {
        Topic topicAllInfoById = getTopicAllInfoById(id);
        List<Reply> replyList = topicAllInfoById.getReplyList();
        for (int i = 0; i < replyList.size(); i++) {
            replyService.getReplyById(replyList.get(i).getId());
        }
        topicDAO.deleteTopicById(id);
    }
}
