package com.lihd.servelt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/2 22:54
 */
public class Demo05Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Demo05Servlet.service");
        //服务器内部转发 记住 不要背api 原理更重要
//        req.getRequestDispatcher("demo06").forward(req,resp);
        //浏览器重定向
        resp.sendRedirect("demo06");
    }



}
