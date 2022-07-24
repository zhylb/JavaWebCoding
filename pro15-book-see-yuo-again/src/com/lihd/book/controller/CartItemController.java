package com.lihd.book.controller;

import com.google.gson.Gson;
import com.lihd.book.pojo.Book;
import com.lihd.book.pojo.Cart;
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

    private String getCart(HttpSession session){
        User user = (User) session.getAttribute("user");
        Cart cart = user.getCart();

        Gson gson = new Gson();
        String json = gson.toJson(cart);

        return "json:"+json;
    }

    private String updateCart(Integer id,Integer num,Integer bookId, HttpSession session){


        User user = (User) session.getAttribute("user");

        CartItem cartItem = new CartItem();
        cartItem.setId(id);
        cartItem.setBuyCount(num);
        cartItem.setBook(new Book(bookId));
        cartItemService.update(cartItem,user.getCart());

        Gson gson = new Gson();
        String json = gson.toJson(user.getCart());

        return "json:"+json;
    }
}
