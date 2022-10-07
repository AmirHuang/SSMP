package com.example.service.impl;

import com.alicp.jetcache.anno.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.BookDao;
import com.example.domain.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    @CacheUpdate(area = "sms", name="book_", key = "#book.id", value = "#book")
    public Boolean update(Book book) {
        System.out.println("update---------");
        return bookDao.updateById(book) > 0;
    }

    @Override
    @CacheInvalidate(area = "sms", name = "book_", key = "#id")
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
//    @Cacheable(value = "cacheSpace", key = "#id")
    @Cached(area = "sms", name="book_", key = "#id", expire = 30, cacheType = CacheType.REMOTE)
//    @CacheRefresh(refresh = 5)
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        bookDao.selectPage(page, null);
        return page;
    }
}
