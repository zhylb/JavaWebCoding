package com.lihd.book.service.impl;

import com.lihd.book.dao.OrderItemDAO;
import com.lihd.book.pojo.Book;
import com.lihd.book.pojo.OrderBean;
import com.lihd.book.pojo.OrderItem;
import com.lihd.book.service.BookService;
import com.lihd.book.service.OrderItemService;

import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/8 13:42
 */
public class OrderItemServiceImpl implements OrderItemService {
    private OrderItemDAO orderItemDAO;
    private BookService bookService;

    @Override
    public List<OrderItem> getOrderItemList(OrderBean orderBean) {


        List<OrderItem> orderItemList = orderItemDAO.getOrderItemList(orderBean);

        for (OrderItem orderItem : orderItemList) {
            Book book = bookService.getBookById(orderItem.getBook().getId());
            orderItem.setBook(book);
        }


        orderBean.setOrderItems(orderItemList);
        return orderItemList;
    }


}
