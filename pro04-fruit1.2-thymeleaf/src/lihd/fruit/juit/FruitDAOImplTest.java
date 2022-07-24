package lihd.fruit.juit;


import lihd.fruit.dao.FruitDAO;
import lihd.fruit.dao.impl.FruitDAOImpl;
import lihd.fruit.pojo.Fruit;
import org.junit.Test;

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
        Fruit fruitById = dao.getFruitById(1);
        System.out.println(fruitById);
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