package com.lihd.qqzone.controller;

import com.lihd.qqzone.pojo.UserBasic;
import com.lihd.qqzone.service.UserBasicService;

import javax.servlet.http.HttpSession;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/6 15:38
 */
public class UserBasicController {
    private UserBasicService userBasicService;

    private String login(String loginId, String pwd, HttpSession session){

        UserBasic userBasic = userBasicService.getUserAllInfoByLogin(loginId, pwd);
        if(userBasic != null){
            session.setAttribute("userBasic",userBasic);
            session.setAttribute("friend",userBasic);
            return "index";
        }
        return "login";
    }

    private String friend(Integer id,HttpSession session){
        UserBasic userBasicById = userBasicService.getUserBasicByIdWithTopicList(id);
        session.setAttribute("friend",userBasicById);
        return "index";
    }
}
