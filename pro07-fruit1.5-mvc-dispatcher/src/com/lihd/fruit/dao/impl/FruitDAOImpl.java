package com.lihd.fruit.dao.impl;


import com.lihd.fruit.dao.FruitDAO;
import com.lihd.myssm.basedao.BaseDAO;
import com.lihd.fruit.pojo.Fruit;

import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/3 10:51
 */
public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {

    @Override
    public List<Fruit> getFruitList() {
        String sql = "select * from fruit";
        return super.queryForList(sql);
    }

    @Override
    public Fruit getFruitById(Integer id) {
        String sql = "select * from fruit where fid = ?";
        return super.queryForOne(sql,id);
    }

    @Override
    public void addFruit(Fruit fruit) {
        String sql = "insert into fruit(fname,price,fcount,remark) values(?,?,?,?)";
        super.updateQuery(sql,fruit.getFname(),fruit.getPrice(),fruit.getFcount(),fruit.getRemark());


    }

    @Override
    public void updateFruitById(Fruit fruit) {
        String sql = "update fruit set fname = ?,price = ?, fcount = ?, remark = ? where fid = ?";
        super.updateQuery(sql,fruit.getFname(),fruit.getPrice(),fruit.getFcount(),fruit.getRemark(),fruit.getFid());

    }

    @Override
    public void delFruitById(Integer id) {
        String sql = "delete from fruit where fid = ?";
        super.updateQuery(sql,id);
    }

    @Override
    public long getFruitCount(String keyword) {
        String sql = "select count(*) from fruit where fname like ? or remark like ?";
        return valueQuery(sql,"%" + keyword + "%","%" + keyword + "%");
    }

    @Override
    public List<Fruit> getFruitList(String keyword, Integer pageNo, Integer pageSize) {

        String sql = "select * from fruit where fname like ? or remark like ? limit ?,?";
        List<Fruit> fruits = super.queryForList(sql, "%" + keyword + "%", "%" + keyword + "%", pageSize * (pageNo - 1), pageSize);

        return fruits;
    }
}
