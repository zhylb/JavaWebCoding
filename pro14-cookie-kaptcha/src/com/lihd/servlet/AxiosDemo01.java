package com.lihd.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/10 14:54
 */
@WebServlet("/axios01")
public class AxiosDemo01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");

        System.out.println("uname = " + uname);
        System.out.println("pwd = " + pwd);

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");//不能用带引号引起来utf-8
//
//        PrintWriter writer = resp.getWriter();
//        writer.print(uname + "-:-" + pwd);

        PrintWriter out = resp.getWriter();
        out.write(uname + "-:-" + pwd);
    }
}
