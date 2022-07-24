package com.lihd.qqzone.controller;

import com.lihd.qqzone.pojo.Topic;
import com.lihd.qqzone.pojo.UserBasic;
import com.lihd.qqzone.service.TopicService;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/6 20:59
 */
public class TopicController {

    private TopicService topicService;

    private String detail(Integer id,HttpSession session){
        Topic topic = topicService.getTopicAllInfoById(id);
        session.setAttribute("topic",topic);
        return "frames/detail";
    }

    private String delete(Integer id){
        topicService.deleteTopicById(id);

        return "redirect:topic.do?operate=getTopicList" ;
//        return "redirect:user.do?operate=friend&id="+id;
    }

    private String getTopicList(HttpSession session){
        //从session中获取当前用户信息
        UserBasic userBasic = (UserBasic)session.getAttribute("userBasic");
        //再次查询当前用户关联的所有的日志
//         topicService.getTopicList(userBasic);
        List<Topic> topicList = topicService.getTopicList(userBasic);
        //设置一下关联的日志列表(因为之前session中关联的friend的topicList和此刻数据库中不一致）
        userBasic.setTopicList(topicList);
        //重新覆盖一下friend中的信息(为什么不覆盖userbasic中？因为main.html页面迭代的是friend这个key中的数据)
        session.setAttribute("friend",userBasic);
        return "frames/main";
    }


    private String add(String title,String content,Integer id){
        Topic topic = new Topic(0, title, content, new Date(), new UserBasic(id), null);
        topicService.addTopic(topic);
        return "redirect:topic.do?operate=getTopicList";
//        return "redirect:user.do?operate=friend&id="+id;
    }


}
