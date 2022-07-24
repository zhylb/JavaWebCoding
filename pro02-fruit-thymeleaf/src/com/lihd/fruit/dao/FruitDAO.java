package com.lihd.fruit.dao;

import com.lihd.fruit.pojo.Fruit;

import java.util.List;

public interface FruitDAO {
    List<Fruit> getFruitList();

    boolean addFruit(Fruit fruit);

    boolean updateFruitById(Fruit fruit);

    Fruit getFruitByFname(String fname);

    boolean delFruit(String fname);

    boolean delFruitById(int id);

}
