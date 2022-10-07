package com.example;

import com.example.dao.BookDao;
import com.example.service.SendMailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;

@SpringBootTest
class SsmpApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private SendMailService sendMailService;
    @Test
    void xx(){
        sendMailService.sendMail();
    }

    @Test
    void contextLoads() {
        System.out.println(bookDao.selectById(1));
    }

}
