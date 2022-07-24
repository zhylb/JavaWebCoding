package com.lihd.qqzone.service.impl;

import com.lihd.qqzone.dao.HostReplyDAO;
import com.lihd.qqzone.dao.ReplyDAO;
import com.lihd.qqzone.dao.UserBasicDAO;
import com.lihd.qqzone.pojo.HostReply;
import com.lihd.qqzone.pojo.Reply;
import com.lihd.qqzone.pojo.Topic;
import com.lihd.qqzone.pojo.UserBasic;
import com.lihd.qqzone.service.ReplyService;

import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/6 20:25
 */
public class ReplyServiceImpl implements ReplyService {
    private ReplyDAO replyDAO ;
    private HostReplyDAO hostReplyDAO;
    private UserBasicDAO userBasicDAO;

    @Override
    public Reply getReplyById(Integer id) {





        return null;
    }

    @Override
    public void addReply(Reply reply) {
        replyDAO.addReply(reply);
    }

    @Override
    public Reply getReplyAllInfoById(Integer id) {
        Reply reply = replyDAO.getReplyAllInfoById(id);
        HostReply hostReply = hostReplyDAO.getHostReplyByReplyId(reply.getId());

        UserBasic userBasicById = userBasicDAO.getUserBasicById(reply.getAuthor().getId());
        reply.setAuthor(userBasicById);

        reply.setHostReply(hostReply);
        return reply;
    }

    @Override
    public List<Reply> getReplyListByTopic(Topic topic) {
        return replyDAO.getReplyList(topic);
    }

    @Override
    public void deleteReplyById(Integer id) {

        hostReplyDAO.deleteHostReplyByReplyId(id);
        replyDAO.deleteReplyById(id);

    }
}
