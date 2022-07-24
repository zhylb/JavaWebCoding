package com.lihd.book.controller;

import com.lihd.book.pojo.User;
import com.lihd.book.service.CartItemService;
import com.lihd.book.service.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/7 16:14
 */
public class UserController {

    private UserService userService;
    private CartItemService cartItemService;

    public String login(String uname, String pwd, HttpSession session){
        User login = userService.login(uname, pwd);
        if (login != null) {
            //已经把购物车信息存入
            cartItemService.getCartByUser(login);

            session.setAttribute("user",login);
            return "redirect:book.do";
        }
        return "user/login";
    }

    private String checkName(String uname){
        User user = userService.checkName(uname);
        if (user != null) {
            return "json:{'uname':'1'}";
        }else {
            return "json:{'uname':'0'}";
        }
    }

    private String register(String uname, String pwd, String email, String code, HttpSession session, HttpServletResponse resp) throws IOException {

        User user = new User(uname, pwd, email);

        Object kaptcha_session_key = session.getAttribute("KAPTCHA_SESSION_KEY");
        if(kaptcha_session_key !=null && kaptcha_session_key.equals(code)){
            userService.register(user);

            return "user/login";
        }else {
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = resp.getWriter();
            writer.write("<script language=\"JavaScript\">alert('验证码错误')</script>");
            return "user/regist";
        }




    }
}
