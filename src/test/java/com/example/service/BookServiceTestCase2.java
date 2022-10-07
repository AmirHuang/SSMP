package com.example.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase2 {
    @Autowired
    private IBookService bookService;

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
        System.out.println(bookService.updateById(book));
    }

    @Test
    void testdelete() {
        System.out.println(bookService.removeById(10));
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
        bookService.list();
    }


    @Test
    void testgetPage() {
        IPage<Book> page = new Page<Book>(2, 5);
        bookService.page(page);
        System.out.println("page " + page.getRecords());
    }

}
