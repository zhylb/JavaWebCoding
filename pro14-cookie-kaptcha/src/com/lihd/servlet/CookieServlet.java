package com.lihd.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/9 15:38
 */
@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 创建cookie
        Cookie cookie = new Cookie("uname","admin");
        //2 添加cookie
        resp.addCookie(cookie);



        //3 获取cookie的一些属性
        //两个关键方法 uname, value
//        String domain = cookie.getDomain();
//        String comment = cookie.getComment();
//        int maxAge = cookie.getMaxAge();
//        String name = cookie.getName();
//        String path = cookie.getPath();
//        int version = cookie.getVersion();
//        String value = cookie.getValue();
//        boolean secure = cookie.getSecure();
//
//
//        System.out.println("domain = " + domain);
//        System.out.println("comment = " + comment);
//        System.out.println("maxAge = " + maxAge);
//        System.out.println("name = " + name);//uname
//        System.out.println("path = " + path);
//        System.out.println("version = " + version);
//        System.out.println("value = " + value);//admin
//        System.out.println("secure = " + secure);


        req.getRequestDispatcher("cookie02").forward(req,resp);


    }
}
