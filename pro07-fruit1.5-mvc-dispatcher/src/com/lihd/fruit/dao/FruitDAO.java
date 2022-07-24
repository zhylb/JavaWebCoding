package com.lihd.fruit.dao;


import com.lihd.fruit.pojo.Fruit;

import java.util.List;

public interface FruitDAO {
    List<Fruit> getFruitList();

    Fruit getFruitById(Integer id);

    void addFruit(Fruit fruit);

    void updateFruitById(Fruit fruit);

    void delFruitById(Integer id);

    long getFruitCount(String keyword);

    List<Fruit> getFruitList(String keyword,Integer pageNo,Integer pageSize);


}
