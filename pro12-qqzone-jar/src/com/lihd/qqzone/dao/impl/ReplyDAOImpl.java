package com.lihd.qqzone.dao.impl;

import com.lihd.myssm.basedao.BaseDAO;
import com.lihd.qqzone.dao.ReplyDAO;
import com.lihd.qqzone.pojo.Reply;
import com.lihd.qqzone.pojo.Topic;

import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/6 13:22
 */
public class ReplyDAOImpl extends BaseDAO<Reply> implements ReplyDAO {

    @Override
    public List<Reply> getReplyList(Topic topic) {

        String sql = "select * from t_reply where topic = ?";
        return super.queryForList(sql,topic.getId());
    }

    @Override
    public Reply getReplyAllInfoById(Integer id) {
        return super.queryForOne("select * from t_reply where id = ?",id);
    }

    @Override
    public void addReply(Reply reply) {
        String sql = "insert into t_reply(content,replyDate,author,topic) values(?,?,?,?) ";
        super.updateQuery(sql,reply.getContent(),reply.getReplyDate(),reply.getAuthor().getId(),reply.getTopic().getId());

    }

    @Override
    public void deleteReplyById(Integer id) {
        String sql = "delete from t_reply where id = ?";
        super.updateQuery(sql,id);
    }
}
