package com.lihd.fruit.controller;

import com.lihd.fruit.pojo.Fruit;
import com.lihd.fruit.service.FruitService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/5 13:27
 */
public class FruitController {
    private FruitService fruitService;

    private String  add(String fname,Integer fcount,Integer price, String remark){


        Fruit fruit = new Fruit(0, fname, fcount, price, remark);
        fruitService.addFruit(fruit);
        return "redirect:fruit.do";
    }

    private String  delete(Integer fid){
        fruitService.delFruitById(fid);
        return "redirect:fruit.do";
    }


    private String  edit(Integer fid,HttpServletRequest req) throws ServletException, IOException {


        Fruit fruit = fruitService.getFruitById(fid);
        req.setAttribute("fruit",fruit);
        return "edit";
    }

    private String  index(Integer pageNo,Integer pageSize,String keyword,HttpServletRequest req) throws ServletException, IOException {

        HttpSession session = req.getSession();

//        fruitService.insertTest();

        if(pageNo==null){
            pageNo = (Integer) session.getAttribute("pageNo");
            if(pageNo == null){
                pageNo = 1;
            }
        }

        if(keyword == null){
            keyword = (String) session.getAttribute("keyword");
            if(keyword == null){
                keyword = "";
            }
        }else {
            //第一次查询
            pageNo = 1;
        }


        pageSize = fruitService.getFruitPage(keyword);



        List<Fruit> fruitList = fruitService.getFruitList(keyword,pageNo,5);

        session.setAttribute("fruitList",fruitList);
        session.setAttribute("pageNo",pageNo);
        session.setAttribute("pageSize",pageSize);
        session.setAttribute("keyword",keyword);


//        super.processTemplate("index",req,resp);
        return "index";

    }

    private String  update(Integer fid,String fname,Integer fcount,Integer price, String remark) {


        Fruit fruit = new Fruit(fid, fname, fcount, price, remark);
        fruitService.updateFruitById(fruit);


        return "redirect:fruit.do";
    }




}
