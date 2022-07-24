package com.lihd.book.dao;

import com.lihd.book.pojo.OrderBean;
import com.lihd.book.pojo.User;

import java.util.List;

public interface OrderDAO {

    Integer addOrder(OrderBean orderBean);

    Integer getIndex();

    List<OrderBean> getOrderList(User user);

}
