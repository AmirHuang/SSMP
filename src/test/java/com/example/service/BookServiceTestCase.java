package com.example.service;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.BookDao;
import com.example.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTestCase {
    @Autowired
    private BookService bookService;

    @Test
    void testgetById() {
        System.out.println(bookService.getById(2));
    }

    @Test
    void testupdate() {
        Book book = new Book();
        book.setId(9);
        book.setName("书99");
        book.setType("flask");
        book.setDescription("dsfsiuyiuh");
        System.out.println(bookService.update(book));
    }

    @Test
    void testdelete() {
        System.out.println(bookService.delete(10));
    }


    @Test
    void testsave() {
        Book book = new Book();
        book.setName("书1");
        book.setType("flask");
        book.setDescription("dsfsiuyiuh");
        System.out.println(bookService.save(book));
    }


    @Test
    void testgetAll() {
        bookService.getAll();
    }


    @Test
    void testgetPage() {
        IPage<Book> page = bookService.getPage(1, 5);
        System.out.println("page " + page.getRecords());
    }

}
