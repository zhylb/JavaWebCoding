package com.lihd.fruit.servlets;

import com.lihd.fruit.dao.FruitDAO;
import com.lihd.fruit.dao.impl.FruitDAOImpl;
import com.lihd.fruit.pojo.Fruit;
import com.lihd.myssm.myspringmvc.ViewBaseServlet;
import com.lihd.utils.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/4 17:08
 */

public class FruitServlet extends ViewBaseServlet {
    private FruitDAO dao = new FruitDAOImpl();



    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String operate = req.getParameter("operate");

        if(operate == null){
            index(req, resp);
            return;
        }

 

       try {
            Method method = this.getClass().getDeclaredMethod(operate,HttpServletRequest.class,HttpServletResponse.class);
             method.setAccessible(true);
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("非法的servlet请求");
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int price = MyUtils.parseIntQuite(req.getParameter("price"));
        int fcount = MyUtils.parseIntQuite(req.getParameter("fcount"));
        String fname = req.getParameter("fname");
        String remark = req.getParameter("remark");
        Fruit fruit = new Fruit(0, fname, fcount, price, remark);
        dao.addFruit(fruit);
        resp.sendRedirect("fruit.do");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int fid = MyUtils.parseIntQuite(req.getParameter("fid"));
        dao.delFruitById(fid);
        resp.sendRedirect("fruit.do");
    }


    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fidStr = req.getParameter("fid");
        int fid = MyUtils.parseIntQuite(fidStr);

        if(fid != -1){
            Fruit fruit = dao.getFruitById(fid);
            req.setAttribute("fruit",fruit);
            super.processTemplate("edit",req,resp);
        }
    }

    private void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();


        int pageNo = 1;
        int pageSize = 0;
        String keyword = "";




        if(session.getAttribute("pageNo") != null){
            pageNo = MyUtils.parseIntQuite(req.getParameter("pageNo"));
            if(pageNo == -1){
                pageNo = (int) session.getAttribute("pageNo");
            }
        }

        if(req.getParameter("keyword") != null){
            //说明是第一进行查询
            keyword = req.getParameter("keyword");

            pageNo = 1;

        }else if(session.getAttribute("keyword") != null){
            keyword = (String) session.getAttribute("keyword");
        }


        long count = dao.getFruitCount(keyword);
        pageSize = (int) (count + 5 - 1)/5;



        List<Fruit> fruitList = dao.getFruitList(keyword,pageNo,5);

        session.setAttribute("fruitList",fruitList);
        session.setAttribute("pageNo",pageNo);
        session.setAttribute("pageSize",pageSize);
        session.setAttribute("keyword",keyword);


        super.processTemplate("index",req,resp);

    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        int fid = MyUtils.parseIntQuite(req.getParameter("fid"));
        int price = MyUtils.parseIntQuite(req.getParameter("price"));
        int fcount = MyUtils.parseIntQuite(req.getParameter("fcount"));
        String fname = req.getParameter("fname");
        String remark = req.getParameter("remark");
        Fruit fruit = new Fruit(fid, fname, fcount, price, remark);
        dao.updateFruitById(fruit);


        resp.sendRedirect("fruit.do");
    }





}
