package com.lihd.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/5 19:33
 */
@WebServlet(urlPatterns = {"/demo02"},
        initParams = {
                @WebInitParam(name = "username",value = "hello"),
                @WebInitParam(name = "password",value = "world"),
        }
)
public class Demo02Servlet extends HttpServlet {
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
}
