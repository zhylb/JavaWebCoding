package com.lihd.book.dao.impl;

import com.lihd.book.dao.CartItemDAO;
import com.lihd.book.pojo.CartItem;
import com.lihd.myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/7 19:01
 */
public class CartItemDAOImpl extends BaseDAO<CartItem> implements CartItemDAO {
    @Override
    public CartItem getCartItemById(Integer id) {
        String sql = "select * from t_cart_item where id = ?";

        return queryForOne(sql,id);
    }

    @Override
    public void addCartItem(CartItem cartItem) {
        String sql = "insert into t_cart_item values (0,?,?,?)";

        super.updateQuery(sql,cartItem.getBook().getId(),cartItem.getBuyCount(),cartItem.getUserBean().getId());
    }

    @Override
    public void updateItem(CartItem cartItem) {
        String sql = "update t_cart_item set buyCount = ? where id = ?";
        super.updateQuery(sql,cartItem.getBuyCount(),cartItem.getId());

    }

    @Override
    public void deleteItemByUserId(Integer id) {
        String sql = "delete from t_cart_item where userBean = ?";
        super.updateQuery(sql,id);
    }

    @Override
    public List<CartItem> getCartItemListByUserId(Integer id) {
        String sql = "select * from t_cart_item where userBean = ?";
        return queryForList(sql,id);
    }


}
