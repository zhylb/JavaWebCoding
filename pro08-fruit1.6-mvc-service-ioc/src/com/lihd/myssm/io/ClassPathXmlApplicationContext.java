package com.lihd.myssm.io;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/5 17:57
 */
public class ClassPathXmlApplicationContext implements BeanFactory{
    private final Map<String,Object> beanMap =  new HashMap<String, Object>();

    public ClassPathXmlApplicationContext(){
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

            //添加依赖
            for (int i = 0; i < beanNodeList.getLength(); i++) {
                Node item = beanNodeList.item(i);
                if(item.getNodeType() == Node.ELEMENT_NODE){
                    // 取到每个bean
                    Element element = (Element) item;
                    String id = element.getAttribute("id");
                    String clazzName = element.getAttribute("class");


                    // 查看bean是否有子元素

                    NodeList childNodes = element.getChildNodes();
                    for (int j = 0; j < childNodes.getLength(); j++) {
                        Node childNode = childNodes.item(j);
                        if(childNode.getNodeType() == Node.ELEMENT_NODE && childNode.getNodeName().equals("property")){
                            //有依赖关系的节点

                            Element childElement = (Element) childNode;

                            String name = childElement.getAttribute("name");
                            String ref = childElement.getAttribute("ref");

                            Object refObj = beanMap.get(ref);

                            //父元素对应的节点
                            Object idObj = beanMap.get(id);

                            Field field = idObj.getClass().getDeclaredField(name);
                            field.setAccessible(true);
                            field.set(idObj,refObj);

                            //上面的逻辑很复杂


                        }

                    }


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
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Object getBean(String id) {
       return beanMap.get(id);
    }
}
