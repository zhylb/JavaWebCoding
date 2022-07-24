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
import java.io.IOException;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/4 12:59
 */
@WebServlet("/add.do")
public class AddServlet extends ViewBaseServlet {

    private FruitDAO dao = new FruitDAOImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        int price = MyUtils.parseIntQuite(req.getParameter("price"));
        int fcount = MyUtils.parseIntQuite(req.getParameter("fcount"));
        String fname = req.getParameter("fname");
        String remark = req.getParameter("remark");
        Fruit fruit = new Fruit(0, fname, fcount, price, remark);
        dao.addFruit(fruit);

        resp.sendRedirect("index");
    }
}
