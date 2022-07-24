package com.lihd.book.service;

import com.lihd.book.pojo.OrderBean;
import com.lihd.book.pojo.User;

import java.util.List;

public interface OrderService {

    void addOrder(OrderBean orderBean);

    List<OrderBean> getOrderList(User user);


}
