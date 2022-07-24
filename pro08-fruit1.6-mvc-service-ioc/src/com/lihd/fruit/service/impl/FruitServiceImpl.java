package com.lihd.fruit.service.impl;

import com.lihd.fruit.dao.FruitDAO;
import com.lihd.fruit.pojo.Fruit;
import com.lihd.fruit.service.FruitService;

import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/5 17:37
 */
public class FruitServiceImpl implements FruitService {

    private FruitDAO fruitDAO;

    @Override
    public List<Fruit> getFruitList(String keyword, Integer pageNo, Integer pageSize) {
        return fruitDAO.getFruitList(keyword, pageNo, pageSize);
    }

    @Override
    public Fruit getFruitById(Integer id) {
        return fruitDAO.getFruitById(id);
    }

    @Override
    public void addFruit(Fruit fruit) {
        fruitDAO.addFruit(fruit);
    }

    @Override
    public void updateFruitById(Fruit fruit) {
        fruitDAO.updateFruitById(fruit);
    }

    @Override
    public void delFruitById(Integer id) {
        fruitDAO.delFruitById(id);
    }

    @Override
    public Integer getFruitPage(String keyword) {
        long count = fruitDAO.getFruitCount(keyword);
        int re = (int) ((count + 5 - 1)/5);
        return re;
    }
}
