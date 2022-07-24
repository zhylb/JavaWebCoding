package com.lihd.book.controller;

import com.lihd.book.pojo.Book;
import com.lihd.book.service.BookService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/7 16:51
 */
public class BookController {
    private BookService bookService;

    public String index(HttpSession session){
        List<Book> bookList = bookService.getBookList();
        session.setAttribute("bookList",bookList);
        return "index";
    }
}
