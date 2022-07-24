package lihd.fruit.servlets;

import lihd.fruit.dao.FruitDAO;
import lihd.fruit.dao.impl.FruitDAOImpl;
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
 * @date ：2022/4/4 12:39
 */

@WebServlet("/del.do")
public class DeleteServlet extends ViewBaseServlet {
    private FruitDAO dao = new FruitDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int fid = MyUtils.parseIntQuite(req.getParameter("fid"));
        dao.delFruitById(fid);
        resp.sendRedirect("index");
    }
}
