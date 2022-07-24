package com.lihd.myssm.myspringmvc;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/5 10:25
 */

@WebServlet("*.do")//这里不要有 ‘/’
public class DispatcherServlet extends ViewBaseServlet {
    private final Map<String,Object> beanMap =  new HashMap<String, Object>();


    @Override
    public void init() throws ServletException {
        super.init();
        //通过反射创建对象

        //读取xml配置文件 构建map

        try {

            InputStream is = getClass().getClassLoader().getResourceAsStream("applicationContext.xml");
//            InputStream is = ClassLoader.getSystemResourceAsStream("applicationContext.xml");


            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.parse(is);

            NodeList beanNodeList = document.getElementsByTagName("bean");

            for (int i = 0; i < beanNodeList.getLength(); i++) {
                Node item = beanNodeList.item(i);
                if(item.getNodeType() == Node.ELEMENT_NODE){
                    // 取到每个bean
                    Element element = (Element) item;
                    String id = element.getAttribute("id");
                    String clazzName = element.getAttribute("class");

                    Class<?> clazz = Class.forName(clazzName);
                    Object instance = clazz.newInstance();

                    beanMap.put(id,instance);//放到map中


                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


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
            Object instance = beanMap.get(servletPath);
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
