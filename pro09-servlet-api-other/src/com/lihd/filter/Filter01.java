package com.lihd.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/5 20:34
 */
public class Filter01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1 进入servlet之前的操作
        System.out.println("FBI ! Open The Door!");

        //2 放行 -> 进入servlet或者filter
        filterChain.doFilter(servletRequest, servletResponse);

        //3 从servlet中出来
        System.out.println("Shut Sound!");
    }

    @Override
    public void destroy() {

    }
}
