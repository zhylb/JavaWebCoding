package com.lihd.book.service.impl;

import com.lihd.book.dao.BookDAO;
import com.lihd.book.pojo.Book;
import com.lihd.book.service.BookService;

import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/7 16:50
 */
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;

    @Override
    public List<Book> getBookList() {
        return bookDAO.getBookList();
    }

    @Override
    public Book getBookById(Integer id) {
        return bookDAO.getBookById(id);
    }
}
