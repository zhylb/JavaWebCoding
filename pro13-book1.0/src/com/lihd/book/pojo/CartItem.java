package com.lihd.book.pojo;

import java.math.BigDecimal;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/7 15:57
 */
public class CartItem {
    private Integer id;
    private Book book;
    private Integer buyCount;

    public Double getTotalValue() {


        BigDecimal bigDecimal = new BigDecimal("" + buyCount);
        BigDecimal bigDecimal1 = new BigDecimal(""+book.getPrice());

        BigDecimal multiply = bigDecimal.multiply(bigDecimal1);

        return multiply.doubleValue();
    }

    private User userBean;
    private Double totalValue;

    public CartItem(){};

    public CartItem(Book book, Integer buyCount, User userBean) {
        this.book = book;
        this.buyCount = buyCount;
        this.userBean = userBean;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public User getUserBean() {
        return userBean;
    }

    public void setUserBean(User userBean) {
        this.userBean = userBean;
    }
}
