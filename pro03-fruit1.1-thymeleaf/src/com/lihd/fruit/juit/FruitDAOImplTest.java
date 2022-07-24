package com.lihd.fruit.juit;

import com.lihd.fruit.dao.FruitDAO;
import com.lihd.fruit.dao.impl.FruitDAOImpl;
import com.lihd.fruit.pojo.Fruit;
import org.junit.Test;

import static org.junit.Assert.*;

public class FruitDAOImplTest {
    private FruitDAO dao = new FruitDAOImpl();

    @Test
    public void getFruitList() {
        for (Fruit fruit : dao.getFruitList()) {
            System.out.println(fruit);
        }

    }

    @Test
    public void getFruitById() {
    }

    @Test
    public void addFruit() {
    }

    @Test
    public void updateFruitById() {
    }

    @Test
    public void delFruitById() {
    }
}