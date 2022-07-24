package com.lihd.book.service;

import com.lihd.book.pojo.OrderBean;
import com.lihd.book.pojo.OrderItem;

import java.util.List;

public interface OrderItemService {
    List<OrderItem> getOrderItemList(OrderBean orderBean);
}
