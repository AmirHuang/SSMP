package com.example.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.Book;
import com.example.service.BookService;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private IBookService iBookService;

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAll(){
        System.out.println("---------------");
        return iBookService.list();
    }

    @PostMapping
    public Boolean save(@RequestBody Book book){
        return iBookService.save(book);
    }

    @PutMapping
    public Boolean updateById(@RequestBody Book book){
        return iBookService.updateById(book);
    }

    @DeleteMapping("{id}")
    public Boolean removeById(@PathVariable Integer id){
        return iBookService.removeById(id);
    }

    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id){
        return iBookService.getById(id);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage, @PathVariable int pageSize){
        return iBookService.getPage(currentPage, pageSize);
    }


    @GetMapping("test/{id}")
    public Book getById2(@PathVariable Integer id){
        return bookService.getById(id);
    }

    @PutMapping("test")
    public Boolean updateById2(@RequestBody Book book){
        return bookService.update(book);
    }

    @DeleteMapping("test/{id}")
    public Boolean removeById2(@PathVariable Integer id){
        return bookService.delete(id);
    }

}
