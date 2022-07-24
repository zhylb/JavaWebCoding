package com.lihd.fruit.juit;

import com.lihd.fruit.dao.FruitDAO;
import com.lihd.fruit.dao.impl.FruitDAOImpl;
import com.lihd.fruit.pojo.Fruit;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FruitDAOImplTest {
    private FruitDAO dao = new FruitDAOImpl();

    @Test
    public void getFruitList() {
        List<Fruit> fruitList = dao.getFruitList();
        fruitList.forEach(System.out::println);
    }

    @Test
    public void addFruit() {
    }

    @Test
    public void updateFruitById() {
    }

    @Test
    public void getFruitByFname() {
    }

    @Test
    public void delFruit() {
    }

    @Test
    public void delFruitById() {
    }
}