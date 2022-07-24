package com.lihd.book.dao;

import com.lihd.book.pojo.OrderBean;
import com.lihd.book.pojo.OrderItem;

import java.util.List;

public interface OrderItemDAO {

    void addOrderItem(OrderItem orderItem);


    Integer getOrderItemCountByOrder(OrderBean orderBean);


    List<OrderItem> getOrderItemList(OrderBean orderBean);







}
