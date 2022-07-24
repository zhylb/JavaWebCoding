package com.lihd.book.controller;

import com.lihd.book.pojo.OrderBean;
import com.lihd.book.pojo.User;
import com.lihd.book.service.OrderItemService;
import com.lihd.book.service.OrderService;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/7 23:18
 */
public class OrderController {
    private OrderService orderService;
    private OrderItemService orderItemService;

    private String checkout(HttpSession session){

        User user = (User) session.getAttribute("user");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date now = new Date();
        String format = sdf.format(now);

        OrderBean orderBean = new OrderBean();
        orderBean.setOrderNo(UUID.randomUUID().toString() + "_"+ format);
        orderBean.setOrderDate(now);
        orderBean.setOrderUser(user);
        orderBean.setOrderMoney(user.getCart().getTotalPrice());

        orderService.addOrder(orderBean);

        session.setAttribute("orderBean",orderBean);

        return "cart/checkout";
    }

    private String showOrderList(HttpSession session){
        User user = (User) session.getAttribute("user");
        List<OrderBean> orderList = orderService.getOrderList(user);

        session.setAttribute("user",user);

        return "order/order";
    }

    private String showOrderItemList(Integer id,HttpSession session){
        User user = (User) session.getAttribute("user");
        for (OrderBean orderBean : user.getOrderList()) {

            if(Objects.equals(orderBean.getId(), id)){

                orderItemService.getOrderItemList(orderBean);

                session.setAttribute("orderBean",orderBean);

                return "order/orderItem";
            }

        }


        return "index";
    }

}
