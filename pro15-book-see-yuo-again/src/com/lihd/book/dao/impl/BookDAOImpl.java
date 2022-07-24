package com.lihd.book.dao.impl;

import com.lihd.book.dao.BookDAO;
import com.lihd.book.pojo.Book;
import com.lihd.myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/7 16:48
 */
public class BookDAOImpl extends BaseDAO<Book> implements BookDAO {

    @Override
    public List<Book> getBookList() {
        String sql = "select * from t_book where bookStatus = 0";
        List<Book> books = super.queryForList(sql);
        return books;
    }

    @Override
    public Book getBookById(Integer id) {

        String sql = "select * from t_book where bookStatus = 0 and id = ?";
        return queryForOne(sql,id);
    }
}
