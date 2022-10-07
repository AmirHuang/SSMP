package com.example.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.controller.utils.R;
import com.example.domain.Book;
import com.example.service.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
//@RestController
@RequestMapping("/books")
public class BookController {

//    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private IBookService iBookService;

    @GetMapping
    public R getAll() {
        log.debug("debug....");
        log.info("info....");
        log.warn("warn....");
        log.error("error....");
        return new R(true, iBookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) {
        return new R(iBookService.save(book));
    }

    @PutMapping
    public R updateById(@RequestBody Book book) {
        return new R(iBookService.updateById(book));
    }

    @DeleteMapping("{id}")
    public R removeById(@PathVariable Integer id) {
        return new R(iBookService.removeById(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
//        if (id == 1) throw new RuntimeException();
        return new R(true, iBookService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {
        IPage<Book> page = iBookService.getPage(currentPage, pageSize, book);
        if (currentPage > page.getPages()) {
            page = iBookService.getPage((int) page.getPages(), pageSize, book);
        }

        return new R(true, page);
    }

}
