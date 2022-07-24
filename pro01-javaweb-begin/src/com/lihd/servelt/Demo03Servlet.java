package com.lihd.servelt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/2 20:09
 */
public class Demo03Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();//效果同req.getSession(true)
        String id = session.getId();
        //session.invalidate();//立即销毁session

        System.out.println("id = " + id);
        System.out.println(session.getMaxInactiveInterval());



        session.setAttribute("username","root");
        session.setAttribute("password","abc123");


    }
}
