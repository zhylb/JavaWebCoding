package com.lihd.book.service.impl;

import com.lihd.book.dao.OrderDAO;
import com.lihd.book.dao.OrderItemDAO;
import com.lihd.book.pojo.CartItem;
import com.lihd.book.pojo.OrderBean;
import com.lihd.book.pojo.OrderItem;
import com.lihd.book.pojo.User;
import com.lihd.book.service.CartItemService;
import com.lihd.book.service.OrderService;

import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/7 22:45
 */
public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;
    private OrderItemDAO orderItemDAO;
    private CartItemService cartItemService;
    @Override
    public void addOrder(OrderBean orderBean) {

        Integer integer = orderDAO.addOrder(orderBean);
        orderBean.setId(integer);
        List<CartItem> list = cartItemService.getCartItemListByUserIdWithBook(orderBean.getOrderUser().getId());
        for (int i = 0; i < list.size(); i++) {
            CartItem cartItem = list.get(i);
            orderItemDAO.addOrderItem(new OrderItem(cartItem.getBook(),cartItem.getBuyCount(),orderBean));
        }

        cartItemService.deleteItemByUserId(orderBean.getOrderUser().getId());


    }

    @Override
    public List<OrderBean> getOrderList(User user) {

        List<OrderBean> orderList = orderDAO.getOrderList(user);

        for (OrderBean orderItem : orderList) {
            Integer count = orderItemDAO.getOrderItemCountByOrder(orderItem);
            orderItem.setOrderItemNum(count);
        }
        //将orderList信息存入
        user.setOrderList(orderList);
        return orderList;
    }




}
