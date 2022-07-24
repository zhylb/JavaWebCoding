package com.lihd.qqzone.dao;

import com.lihd.qqzone.pojo.Reply;
import com.lihd.qqzone.pojo.Topic;

import java.util.List;

public interface ReplyDAO {

    List<Reply> getReplyList(Topic topic);

    Reply getReplyAllInfoById(Integer id);

    void addReply(Reply reply);

    void deleteReplyById(Integer id);

}
