package com.lihd.book.service.impl;

import com.lihd.book.dao.CartItemDAO;
import com.lihd.book.pojo.Book;
import com.lihd.book.pojo.Cart;
import com.lihd.book.pojo.CartItem;
import com.lihd.book.pojo.User;
import com.lihd.book.service.BookService;
import com.lihd.book.service.CartItemService;
import com.lihd.book.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/7 19:09
 */
public class CartItemServiceImpl implements CartItemService {

    private CartItemDAO cartItemDAO;
    private UserService userService;
    private BookService bookService;
    @Override
    public CartItem getCartItemById(Integer id) {
        return cartItemDAO.getCartItemById(id);
    }

    @Override
    public void addCart(CartItem cartItem,Cart cart) {

        //更新购物车数据

        Map<Integer, CartItem> itemMap = cart.getItemMap();


        if(itemMap.containsKey(cartItem.getBook().getId())){
            //不是第一次
            CartItem cartItemTemp = itemMap.remove(cartItem.getBook().getId());
            cartItemTemp.setBuyCount(cartItemTemp.getBuyCount() + 1);

            cartItemDAO.updateItem(cartItemTemp);
            itemMap.put(cartItemTemp.getBook().getId(),cartItemTemp);
        }else {
            cartItem.setBuyCount(1);
            addCartItem(cartItem);

            itemMap.put(cartItem.getBook().getId(),cartItem);

        }


    }

    @Override
    public void update(CartItem cartItem,Cart cart) {

        //更新购物车数据 确保 cartItem的book id不为空

        Map<Integer, CartItem> itemMap = cart.getItemMap();

        CartItem remove = itemMap.remove(cartItem.getBook().getId());

        remove.setBuyCount(cartItem.getBuyCount());


        //更新值 这样json才有数据 下面同理
        remove.getTotalValue();



        //更新map 更新数据库
        itemMap.put(cartItem.getBook().getId(), remove);



        cart.getTotalBookCount();
        cart.getTotalPrice();

        cartItemDAO.updateItem(cartItem);


    }



    @Override
    public Cart getCartByUser(User user) {
        List<CartItem> cartList = getCartItemListByUserIdWithBook(user.getId());
        Cart cart = new Cart();
        Map<Integer, CartItem> itemMap = new HashMap<>();
        for (CartItem cartItem : cartList) {
            cartItem.getTotalValue();
            itemMap.put(cartItem.getBook().getId(),cartItem);
        }
        cart.setItemMap(itemMap);
        user.setCart(cart);

        cart.getTotalBookCount();
        cart.getTotalPrice();

        return cart;
    }

    @Override
    public void deleteItemByUserId(Integer id) {
        cartItemDAO.deleteItemByUserId(id);
    }

    @Override
    public void addCartItem(CartItem cartItem) {
        Book bookById = bookService.getBookById(cartItem.getBook().getId());
        cartItem.setBook(bookById);
        cartItemDAO.addCartItem(cartItem);
    }

    @Override
    public List<CartItem> getCartItemListByUserIdWithBook(Integer id) {

        List<CartItem> cartItemList = cartItemDAO.getCartItemListByUserId(id);

        cartItemList.forEach(cartItem -> {cartItem.setBook(bookService.getBookById(cartItem.getBook().getId()));});


        return cartItemList;
    }
}
