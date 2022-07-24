package com.lihd.fruit.service;

import com.lihd.fruit.pojo.Fruit;

import java.util.List;

public interface FruitService {
    List<Fruit> getFruitList(String keyword,Integer pageNo,Integer pageSize);

    Fruit getFruitById(Integer id);

    void addFruit(Fruit fruit);

    void updateFruitById(Fruit fruit);

    void delFruitById(Integer id);

    Integer getFruitPage(String keyword);
}
