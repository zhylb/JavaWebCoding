package lihd.fruit.servlets;


import lihd.fruit.dao.FruitDAO;
import lihd.fruit.dao.impl.FruitDAOImpl;
import lihd.fruit.pojo.Fruit;
import lihd.myssm.myspringmvc.ViewBaseServlet;
import lihd.utils.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/3 11:08
 */
@WebServlet("/index")
public class IndexServlet extends ViewBaseServlet {
    private FruitDAO fruitDAO = new FruitDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();


        int pageNo;
        int pageSize = 0;
        String keyword = "";


        if(req.getParameter("keyword") != null){
            //说明是第一进行查询
            keyword = req.getParameter("keyword");

        }else if(session.getAttribute("keyword") != null){
            keyword = (String) session.getAttribute("keyword");
        }

        if(session.getAttribute("pageNo") != null){
            pageNo = MyUtils.parseIntQuite(req.getParameter("pageNo"));
            if(pageNo == -1){
                pageNo = (int) session.getAttribute("pageNo");
            }
        }else {
            pageNo = 1;
        }

        long count = fruitDAO.getFruitCount(keyword);
        pageSize = (int) (count + 5 - 1)/5;



        List<Fruit> fruitList = fruitDAO.getFruitList(keyword,pageNo,5);

        session.setAttribute("fruitList",fruitList);
        session.setAttribute("pageNo",pageNo);
        session.setAttribute("pageSize",pageSize);
        session.setAttribute("keyword",keyword);


        super.processTemplate("index",req,resp);

    }
}
