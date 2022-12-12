package com.example.mongodbTestCase;

import com.example.domain.Book;
import com.example.domain.Employee;
import kotlin.collections.UCollectionsKt;
import lombok.Data;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class mongodbTest {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void testsave1(){
        Book book = new Book();
        book.setId(2);
        book.setName("sss");
        book.setType("dsfsd");
        book.setDescription("dsfsdf");
        System.out.println(mongoTemplate.save(book));
    }

    @Test
    void testfind1(){
        List<Book> all = mongoTemplate.findAll(Book.class);
        System.out.println(all);
    }

    @Test
    void testfind2(){
        List<Employee> all = mongoTemplate.findAll(Employee.class);
        System.out.println(all);
    }

    @Test
    void testinsert(){
        Employee employee = new Employee(1, "xiaoming", 30, 1000.00, new Date());
        mongoTemplate.insert(employee);
    }

    @Test
    void testfind3(){
        List<Employee> all = mongoTemplate.findAll(Employee.class);
        System.out.println(all);
    }

}
