package com.lihd.myssm.myspringmvc;

import com.lihd.myssm.io.BeanFactory;
import com.lihd.myssm.io.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/5 10:25
 */

@WebServlet("*.do")//这里不要有 ‘/’
public class DispatcherServlet extends ViewBaseServlet {

    private BeanFactory beanFactory;


    @Override
    public void init() throws ServletException {
        super.init();
        beanFactory = new ClassPathXmlApplicationContext();

    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //通过反射构建对象
        String servletPath = req.getServletPath();

        //此时的名字 为 /hello.do  我们要取出真正的名字  /hello.do -> hello
        servletPath = servletPath.substring(1, servletPath.indexOf(".do"));


        String operate = req.getParameter("operate");

        if(operate == null){
            operate = "index";
        }
        //获取对应的对象

        //利用反射调用
        try {
            Object instance = beanFactory.getBean(servletPath);
            Class<?> clazz = instance.getClass();
            //1 获取参数
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                if(operate.equals(method.getName())){
                    //找到了方法
                    method.setAccessible(true);
                    //获取参数
                    Parameter[] parameters = method.getParameters();
                    Object[] paraObjs = new Object[parameters.length];
                    for (int i = 0; i < parameters.length; i++) {
                        Parameter parameter = parameters[i];
                        String argName = parameter.getName();
                        if("req".equals(argName)){
                            paraObjs[i] = req;
                        }else if("resp".equals(argName)){
                            paraObjs[i] = resp;
                        }else if("session".equals(argName)){
                            paraObjs[i] = req.getSession();
                        }else {
                            String valueStr = req.getParameter(argName);
                            paraObjs[i] = valueStr;
                            if(valueStr != null){
                                String simpleName = parameter.getType().getSimpleName();
                                

                                if("Integer".equals(simpleName)){
                                    paraObjs[i] = Integer.parseInt(valueStr);
                                }
                            }


                        }
                    }

                    String invoke = (String) method.invoke(instance, paraObjs);

                    if(invoke.startsWith("redirect:")){
                        invoke = invoke.substring("redirect:".length());
                        resp.sendRedirect(invoke);
                    }else {
                        super.processTemplate(invoke,req,resp);
                    }
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
