package com.lihd.servlet;

import com.google.gson.Gson;
import com.lihd.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/10 14:54
 */
@WebServlet("/axios03")
public class AxiosDemo03 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        StringBuilder sb = new StringBuilder();
        BufferedReader reader = req.getReader();
        String s;
        while((s = reader.readLine()) != null){
            sb.append(s);
        }


        String str = sb.toString();
        Gson gson = new Gson();
        User user = gson.fromJson(str, User.class);

        user.setUname("神赵云");
        user.setPwd("龙战于野");

        String jsonStr = gson.toJson(user);


        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");//不能用带引号引起来utf-8
        PrintWriter writer = resp.getWriter();
        writer.write(jsonStr);

    }
}
