package com.lihd.book.dao.impl;

import com.lihd.book.dao.OrderItemDAO;
import com.lihd.book.pojo.OrderBean;
import com.lihd.book.pojo.OrderItem;
import com.lihd.myssm.basedao.BaseDAO;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/7 22:33
 */
public class OrderItemDAOImpl extends BaseDAO<OrderItem> implements OrderItemDAO {
    @Override
    public void addOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item values(0,?,?,?)";
        super.updateQuery(sql,orderItem.getBook().getId(),orderItem.getBuyCount(),orderItem.getOrderBean().getId());
    }

    @Override
    public Integer getOrderItemCountByOrder(OrderBean orderBean) {

        String sql = "SELECT SUM(buyCount) FROM t_order_item WHERE orderBean = ?";
        BigDecimal bigDecimal = valueQuery(sql, orderBean.getId());
        if(bigDecimal == null) return 0;
        else  return bigDecimal.intValue();

    }

    @Override
    public List<OrderItem> getOrderItemList(OrderBean orderBean) {
        String sql = "select * from t_order_item where orderBean = ?";
        return queryForList(sql,orderBean.getId());
    }
}
