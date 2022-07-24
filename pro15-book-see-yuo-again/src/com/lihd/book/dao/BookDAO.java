package com.lihd.book.dao;

import com.lihd.book.pojo.Book;

import java.util.List;

public interface BookDAO {

    List<Book> getBookList();

    Book getBookById(Integer id);
}
