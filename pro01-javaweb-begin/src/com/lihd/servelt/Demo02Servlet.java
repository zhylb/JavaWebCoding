package com.lihd.servelt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/2 18:58
 */
public class Demo02Servlet extends HttpServlet {
    private Demo02Servlet(){
        System.out.println("Servlet被创建");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet初始化");
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet执行服务");
    }


    @Override
    public void destroy() {
        System.out.println("servlet被销毁");
    }
}
