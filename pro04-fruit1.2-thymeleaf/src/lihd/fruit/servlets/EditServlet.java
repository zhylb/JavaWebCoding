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
 * @date ：2022/4/3 19:52
 */
@WebServlet("/edit.do")
public class EditServlet extends ViewBaseServlet {
    private FruitDAO dao = new FruitDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fidStr = req.getParameter("fid");
        int fid = MyUtils.parseIntQuite(fidStr);

        if(fid != -1){
            Fruit fruit = dao.getFruitById(fid);
            req.setAttribute("fruit",fruit);
            super.processTemplate("edit",req,resp);
        }


//        dao.getFruitById();
    }
}
