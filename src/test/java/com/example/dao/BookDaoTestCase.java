package com.example.dao;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    void testselectById() {
        System.out.println(bookDao.selectById(2));
    }

    @Test
    void testinsert() {
        Book book = new Book();
        book.setName("书1");
        book.setType("flask");
        book.setDescription("dsfsiuyiuh");
        System.out.println(bookDao.insert(book));
    }

    @Test
    void testdelete(){
        System.out.println(bookDao.deleteById(1));
    }

    @Test
    void testupdate(){
        Book book = new Book();
        book.setId(9);
        book.setName("书9");
        book.setType("flask");
        book.setDescription("dsfsiuyiuh");
        System.out.println(bookDao.updateById(book));
    }

    @Test
    void testgetPage(){
        IPage page = new Page(1, 5);
        IPage iPage = bookDao.selectPage(page, null);
        List records = iPage.getRecords();
        System.out.println(records);;
    }

    @Test
    void testselectList() {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "Spring");
        bookDao.selectList(queryWrapper);
    }

    @Test
    void testselectList2() {
        String name = null;
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(name != null, Book::getName, "Spring");
        bookDao.selectList(lqw);
    }


}
