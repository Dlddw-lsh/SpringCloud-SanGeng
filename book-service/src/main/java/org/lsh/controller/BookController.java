package org.lsh.controller;

import com.lsh.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.lsh.service.BookService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class BookController {

    @Resource
    BookService service;

    @RequestMapping("/book/{bid}")
    Book findBookById(@PathVariable("bid") int bid, HttpServletRequest request) {
        log.info("获取Test请求头： {}", request.getHeader("Test"));
        return service.getBookById(bid);
    }
}