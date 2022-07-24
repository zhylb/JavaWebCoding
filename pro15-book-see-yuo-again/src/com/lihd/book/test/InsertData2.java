package com.lihd.book.test;

import com.lihd.book.service.OrderItemService;
import com.lihd.book.service.OrderService;
import com.lihd.book.service.impl.OrderItemServiceImpl;
import com.lihd.book.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/** createDatabaseAndImportData
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/6/13 14:28
 */
public class InsertData2 {
    Random r = new Random();

    OrderService orderService = new OrderServiceImpl();

    OrderItemService orderItemService = new OrderItemServiceImpl();


    /**
     * Test01 : 插入数据
     *
     *
     *
     */
    @Test
    public void test01 (){
        //买几本书 ，每本书买几本， 一共多少钱
        int[] money = {0, 99, 200, 50, 40, 30, 27, 45, 19, 20, 20, 23};


        int countMoney = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = r.nextInt(10) + 1;
        for (int i = 0; i < len; i++) {
            int key = r.nextInt(11) + 1;
            countMoney += money[key];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        

        





        //上面的书属于那个订单 订单的金额设置好 属于那个用户

        //

    }


    /**
     * Test02 :
     *
     *
     *
     */
    @Test
    public void test02 () throws FileNotFoundException {
        System.setOut(new PrintStream("src/com/lihd/book/test/result.txt"));
        int orderBeanId = 1;
        int[] money = {0, 99, 200, 50, 40, 30, 27, 45, 19, 20, 20, 23};
        for (int i = 1; i <= 268; i++) {
            int buyTime = r.nextInt(5) + 1;
            for (int j = 0; j < buyTime; j++) {

                //每一个订单的处理
                int countMoney = 0;
                HashMap<Integer, Integer> map = new HashMap<>();
                int len = r.nextInt(10) + 1;
                for (int k = 0; k < len; k++) {
                    int key = r.nextInt(11) + 1;
                    countMoney += money[key];
                    if (map.containsKey(key)) {
                        map.put(key, map.get(key) + 1);
                    } else {
                        map.put(key, 1);
                    }
                }
                String orderNo ="\"" +  UUID.randomUUID().toString() + "\"" ;
                String randomDate = "\"" + RandomDate.getRandomDate() + "\"" ;
                int randS = r.nextInt(3) == 1 ? 0 : 1;

                String sql = "insert into t_order values("+ (orderBeanId) +"," + orderNo + "," + randomDate  + "," + i  + "," + countMoney+","+ randS+ ");";
                System.out.println(sql);
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

                    String sql2 = "insert into t_order_item(book, buyCount, orderBean) values( " +
                            "" + entry.getKey() + "," + entry.getValue() + ","+ orderBeanId + ") ;";
                    System.out.println(sql2);
                }
                orderBeanId ++;
            }
        }
    }

    /**
     * Test02 :
     *
     *
     *
     */
    @Test
    public void test03 () throws FileNotFoundException {
        System.setOut(new PrintStream("src/com/lihd/book/test/result222.txt"));
        for (int i = 1; i <= 268; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int len = r.nextInt(10) + 1;
            for (int k = 0; k < len; k++) {
                int key = r.nextInt(11) + 1;
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 1);
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

                String sql2 = "insert into t_cart_item(book, buyCount, userBean) values( " +
                        "" + entry.getKey() + "," + entry.getValue() + ","+ i + ") ;";
                System.out.println(sql2);
            }
        }
    }






}
