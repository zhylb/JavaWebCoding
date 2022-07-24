package com.lihd.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/5 20:41
 */
@WebFilter("*.do")
public class Demo01Filter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1 进入servlet之前的操作
        System.out.println("Demo01Filter.doFilter");

        //2 放行 -> 进入servlet或者filter
        filterChain.doFilter(servletRequest, servletResponse);

        //3 从servlet中出来
        System.out.println("Demo01Filter.doFilter");

    }

    @Override
    public void destroy() {

    }
}
