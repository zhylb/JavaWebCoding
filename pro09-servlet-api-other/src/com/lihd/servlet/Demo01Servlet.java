package com.lihd.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * 知识点
 * 获取对象
 *      getServletConfig()
 *      getServletContext()
 * 获取初始化参数
 *      getInitParameters()
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/5 19:21
 */


public class Demo01Servlet extends HttpServlet {

    @Override
    public void init() throws ServletException {


        //1 获取servletConfig对象
        ServletConfig servletConfig = getServletConfig();



        //2 获取servletContext对象 有很多类都能获取servletContext对象
        ServletContext servletContext = getServletContext();
        ServletContext servletContext1 = getServletConfig().getServletContext();

        String username = servletConfig.getInitParameter("username");
        String password = servletConfig.getInitParameter("password");

        System.out.println("username = " + username);
        System.out.println("password = " + password);

        String country = servletContext.getInitParameter("country");
        String color = servletContext.getInitParameter("color");
        System.out.println("country = " + country);
        System.out.println("color = " + color);
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ServletContext servletContext = req.getServletContext();
//        ServletContext servletContext1 = req.getSession().getServletContext();
//    }
}
