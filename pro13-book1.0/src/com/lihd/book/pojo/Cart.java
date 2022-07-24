package com.lihd.book.pojo;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/7 18:14
 */
public class Cart {

    private Map<Integer, CartItem> ItemMap;
    private Double totalPrice;
    private Integer totalCount;
    private Integer totalBookCount;


    public Map<Integer, CartItem> getItemMap() {
        return ItemMap;
    }

    public void setItemMap(Map<Integer, CartItem> itemMap) {
        ItemMap = itemMap;
    }

    public Double getTotalPrice() {
        BigDecimal bigDecimal = new BigDecimal(0);
        for (CartItem value : ItemMap.values()) {
            BigDecimal t = new BigDecimal(""+value.getBook().getPrice());
            t = t.multiply(new BigDecimal(value.getBuyCount()));
            bigDecimal = bigDecimal.add(t);
        }
//        for (CartItem value : ItemMap.values()) {
//
//            totalPrice += value.getBuyCount() * value.getBook().getPrice();
//        }
        return bigDecimal.doubleValue();
    }


    public Integer getTotalCount() {
        return ItemMap.size();
    }

    public Integer getTotalBookCount(){

        totalBookCount = 0;

        Optional<Integer> reduce = ItemMap.values().stream().map(CartItem::getBuyCount).reduce(Integer::sum);
        totalBookCount = reduce.get();



        return totalBookCount;

    }

}
