package com.lihd.qqzone.service;

import com.lihd.qqzone.pojo.Reply;
import com.lihd.qqzone.pojo.Topic;

import java.util.List;

public interface ReplyService {

    Reply getReplyById(Integer id);

    void addReply(Reply reply);

    Reply getReplyAllInfoById(Integer id);

    List<Reply> getReplyListByTopic(Topic topic);

    void deleteReplyById(Integer id);
}
