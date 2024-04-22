package org.lsh.controller;

import com.lsh.entity.Book;
import jakarta.annotation.Resource;
import org.lsh.service.BookService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RefreshScope // 实现Nacos配置中心实时刷新
public class BookController {

    @Value("${test.hello}")
    String hello;

    @Resource
    BookService service;

    @RequestMapping("/book/{bid}")
    Book findBookById(@PathVariable("bid") int bid){
        System.out.println("bookService");
        return service.getBookById(bid);
    }

    @RequestMapping("/test")
    String test(){
        return hello;
    }
}