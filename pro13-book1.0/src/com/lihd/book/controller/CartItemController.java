package com.lihd.book.controller;

import com.lihd.book.pojo.Book;
import com.lihd.book.pojo.CartItem;
import com.lihd.book.pojo.User;
import com.lihd.book.service.CartItemService;

import javax.servlet.http.HttpSession;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/7 19:36
 */
public class CartItemController {
    private CartItemService cartItemService;


    private String index(HttpSession session){

        User user = (User) session.getAttribute("user");
        cartItemService.getCartByUser(user);
        return "index";
    }

    private String addItem(Integer bookId, HttpSession session){
        User user = (User) session.getAttribute("user");
        cartItemService.addCart(new CartItem(new Book(bookId),1,user), user.getCart());
        return "cart/cart";
    }

    private String updateCart(Integer id,Integer num,Integer bookId, HttpSession session){
        //cart.do?operate=updateCart?id=null&num=0&bookId=3

//        if(num <= 0) {
//            throw new RuntimeException("服务器被攻击");
//        }


        User user = (User) session.getAttribute("user");

        CartItem cartItem = new CartItem();
        cartItem.setId(id);
        cartItem.setBuyCount(num);
        cartItem.setBook(new Book(bookId));
        cartItemService.update(cartItem,user.getCart());

        return "cart/cart";
    }
}
