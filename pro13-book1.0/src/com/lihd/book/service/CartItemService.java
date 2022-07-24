package com.lihd.book.service;

import com.lihd.book.pojo.Cart;
import com.lihd.book.pojo.CartItem;
import com.lihd.book.pojo.User;

import java.util.List;

public interface CartItemService {


    CartItem getCartItemById(Integer id);
    /**
     * 调用前 先调用getCartByUser保证cart不是null
     * @Author lihd
     * @Description //TODO LiHaoda
     * @Date 19:20 2022/4/7
     * @Param [cartItem, cart]
     * @return void
     **/
    void addCart(CartItem cartItem,Cart cart);

    Cart getCartByUser(User user);

    void deleteItemByUserId(Integer id);

    void addCartItem(CartItem cartItem);


    List<CartItem> getCartItemListByUserIdWithBook(Integer id);

    void update(CartItem cartItem,Cart cart);
}
