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
 * @date ：2022/4/9 15:58
 */
@WebServlet("/cookie02")
public class CookieServlet02 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        for (Cookie cookie : cookies) {
            /*  下面是获取到的信息
            uname  admin
            Idea-8296e770  aba0359c-6458-40f9-b16a-e0d9b0b11e4c
            Idea-8296eb32  d570dd70-cff2-486a-9260-5e3146c13392
            UM_distinctid  17fa1657c621ee-0d8b633f2f6c4-f791539-144000-17fa1657c633f6
            CNZZDATA5175564  cnzz_eid%3D767437561-1647677703-%26ntime%3D1647677703
            53revisit  1647680257636
            Webstorm-be5713b6  898c4643-6a23-488e-ab61-a648477d7bc4
            */
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println(name + "  " + value);
        }

        req.getRequestDispatcher("dis.html").forward(req,resp);

    }
}
