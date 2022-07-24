package com.lihd.book.dao;

import com.lihd.book.pojo.CartItem;

import java.util.List;

public interface CartItemDAO {

    CartItem getCartItemById(Integer id);

    void addCartItem(CartItem cartItem);

    void updateItem(CartItem cartItem);

    void deleteItemByUserId(Integer id);

    List<CartItem> getCartItemListByUserId(Integer id);

}
