package com.lihd.qqzone.service.junit;

import com.lihd.qqzone.pojo.Reply;
import com.lihd.qqzone.pojo.Topic;
import com.lihd.qqzone.service.TopicService;
import com.lihd.qqzone.service.impl.TopicServiceImpl;
import org.junit.Test;

import java.util.List;

public class TopicServiceImplTest {

    private TopicService service =new TopicServiceImpl();


    @Test
    public void getTopicListAllInfo() {
    }

    @Test
    public void getTopicList() {
    }

    @Test
    public void getTopicById() {
    }

    @Test
    public void getTopicAllInfoById() {

        Topic topicAllInfoById = service.getTopicAllInfoById(8);
        List<Reply> replyList = topicAllInfoById.getReplyList();

        replyList.forEach(System.out::println);
//        System.out.println(topicAllInfoById);


    }

    @Test
    public void addTopic() {
    }

    @Test
    public void deleteTopicById() {
    }
}