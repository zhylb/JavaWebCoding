package com.lihd.zfilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/9 17:22
 */

@WebFilter(
        urlPatterns = "*.do",
        initParams = {
                @WebInitParam(name = "whiteList",value = "/pro13/render.do?page=user/login," +
                        "/pro13/render.do?page=user/login," +
                        "/pro13/render.do?page=user/register," +
                        "/pro13/user.do?null," +
                        "/pro13/user.do?operate=register," +
                        "/pro13/render?page=index," +
                        "/pro13/render.do?page=user/regist," +
                        ""),
                @WebInitParam(name = "containList",value = "operate=checkName&uname=," +
                        "," +
                        ",")
        }

)
public class SessionFilter implements Filter {

    List<String> whiteList;
    List<String> containList;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String str = filterConfig.getInitParameter("whiteList");
        String str1 = filterConfig.getInitParameter("containList");

        String[] split = str.split(",");
        String[] split1 = str1.split(",");
        whiteList = Arrays.asList(split);
        containList = Arrays.asList(split1);


    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();


        String uri = req.getRequestURI();
        String queryString = req.getQueryString();
        String url = uri + "?" + queryString;
        System.out.println(url);
        if(whiteList.contains(url)){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        for (String string : containList) {
            if(url.contains(string)){
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }


        if(session.getAttribute("user") == null){
            resp.sendRedirect("render.do?page=user/login");
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }


    }

    @Override
    public void destroy() {

    }
}
