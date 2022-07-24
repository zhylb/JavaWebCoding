package com.lihd.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/3 15:41
 */
@WebServlet("/demo01")
public class Demo01Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //内置了四种域对象
        //pageContext似乎无法操作 作用范围是一个JSP页面 由于JSP已经过时 因此不再讨论

        //request域 作用范围是一次请求
        req.setAttribute("request","request");
        //session 域 作用范围是一次会话
        HttpSession session = req.getSession();
        session.setAttribute("session","session");

        //ServletContext (application) 域 作用范围整个web应用
        ServletContext application = req.getServletContext();
        application.setAttribute("application","ServletContext");

        //1 对于服务器内部 转发
//        req.getRequestDispatcher("demo02").forward(req,resp);
        //2 对于浏览器重定向
        resp.sendRedirect("demo02");

    }
}
