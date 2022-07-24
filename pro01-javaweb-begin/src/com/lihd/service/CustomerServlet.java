package com.lihd.service;

import com.lihd.bean.Customer;
import com.lihd.dao.BaseDAO;
import com.lihd.dao.CustomerDAO;
import com.lihd.dao.impl.CustomerDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/2 15:46
 */
public class CustomerServlet extends HttpServlet {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //为post方法设置编码 对于get方法不用设置 必须设置在第一行
        req.setCharacterEncoding("UTF-8");


        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String birth = req.getParameter("birth");

        System.out.println(name);
        System.out.println(email);
        System.out.println(birth);

        try {
            Customer customer = new Customer(0, name, email, new Date(sdf.parse(birth).getTime()));
            CustomerDAOImpl customerDAO = new CustomerDAOImpl();
            Connection connection = BaseDAO.getConnection1();
            customerDAO.insertCustomer(connection,customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("添加成功");


    }
}

