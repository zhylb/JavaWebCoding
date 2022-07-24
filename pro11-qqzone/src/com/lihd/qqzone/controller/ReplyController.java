package com.lihd.qqzone.controller;

import com.lihd.qqzone.pojo.Reply;
import com.lihd.qqzone.pojo.Topic;
import com.lihd.qqzone.pojo.UserBasic;
import com.lihd.qqzone.service.ReplyService;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/6 23:02
 */
public class ReplyController {

    private ReplyService replyService;

    private String add(Integer topicId,String title,String content, HttpSession session){

        UserBasic userBasic = (UserBasic) session.getAttribute("userBasic");

        Reply reply = new Reply(0,content, new Date(), userBasic, new Topic(topicId),null);



        replyService.addReply(reply);


        return "redirect:topic.do?operate=detail&id="+topicId;
    }

    private String delete(Integer id,Integer topicId){

        replyService.deleteReplyById(id);

        return "redirect:topic.do?operate=detail&id="+topicId;

    }

}
