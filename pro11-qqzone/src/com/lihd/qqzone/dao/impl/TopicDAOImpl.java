package com.lihd.qqzone.dao.impl;

import com.lihd.myssm.basedao.BaseDAO;
import com.lihd.qqzone.dao.TopicDAO;
import com.lihd.qqzone.pojo.Topic;
import com.lihd.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/6 13:22
 */
public class TopicDAOImpl extends BaseDAO<Topic> implements TopicDAO {
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {

        String sql = "select * from t_topic where author = ?";

        return super.queryForList(sql,userBasic.getId());
    }

    @Override
    public Topic getTopicById(Integer id) {
        String sql = "select * from t_topic where id = ?";

        return super.queryForOne(sql,id);
    }

    @Override
    public void addTopic(Topic topic) {
        String sql = "insert into t_topic(title,content,topicDate,author) values(?,?,?,?)";
        super.updateQuery(sql,topic.getTitle(),topic.getContent(),topic.getTopicDate(),topic.getAuthor().getId());

    }

    @Override
    public void deleteTopicById(Integer id) {
        String sql = "delete from t_topic where id = ?";
        super.updateQuery(sql,id);
    }
}
