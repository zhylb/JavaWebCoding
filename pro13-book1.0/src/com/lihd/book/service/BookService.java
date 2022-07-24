package com.lihd.book.service;

import com.lihd.book.pojo.Book;

import java.util.List;

public interface BookService {
    List<Book> getBookList();
    Book getBookById(Integer id);
}
