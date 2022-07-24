package lihd.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/3 15:43
 */
@WebServlet("/demo02")
public class Demo02Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object request1 = req.getAttribute("request");

        HttpSession session = req.getSession();
        Object session1 = session.getAttribute("session");

        ServletContext application = req.getServletContext();
        Object application1 = application.getAttribute("application");

        System.out.println("----------------------------------------");
        System.out.println("request1 = " + request1);
        System.out.println("session1 = " + session1);
        System.out.println("application1 = " + application1);

    }
}
