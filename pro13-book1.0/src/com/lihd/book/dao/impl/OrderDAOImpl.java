package com.lihd.book.dao.impl;

import com.lihd.book.dao.OrderDAO;
import com.lihd.book.pojo.OrderBean;
import com.lihd.book.pojo.User;
import com.lihd.myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/7 22:40
 */
public class OrderDAOImpl extends BaseDAO<OrderBean> implements OrderDAO {
    @Override
    public Integer addOrder(OrderBean orderBean) {
        String sql = "insert into t_order values(0,?,?,?,?,0)";
        return super.updateQuery(sql,orderBean.getOrderNo(),orderBean.getOrderDate(),orderBean.getOrderUser().getId(),orderBean.getOrderMoney());
    }

    @Override
    public Integer getIndex() {
        return super.valueQuery("select max(id) from t_order");
    }

    @Override
    public List<OrderBean> getOrderList(User user) {
        String sql = "select * from t_order where orderUser = ?";
        return queryForList(sql,user.getId());
    }
}
