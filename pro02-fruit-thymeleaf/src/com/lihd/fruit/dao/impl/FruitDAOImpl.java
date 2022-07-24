package com.lihd.fruit.dao.impl;

import com.lihd.fruit.dao.FruitDAO;
import com.lihd.fruit.pojo.Fruit;
import com.lihd.myssm.basedao.BaseDAO;

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
    public boolean addFruit(Fruit fruit) {
        return false;
    }

    @Override
    public boolean updateFruitById(Fruit fruit) {
        return false;
    }

    @Override
    public Fruit getFruitByFname(String fname) {
        return null;
    }

    @Override
    public boolean delFruit(String fname) {
        return false;
    }

    @Override
    public boolean delFruitById(int id) {
        return false;
    }
}
