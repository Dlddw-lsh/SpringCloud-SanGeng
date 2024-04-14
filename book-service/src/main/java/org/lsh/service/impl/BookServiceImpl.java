package org.lsh.service.impl;

import com.lsh.entity.Book;
import org.lsh.mapper.BookMapper;
import org.lsh.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookMapper mapper;

    @Override
    public Book getBookById(int bid) {
        return mapper.getBookById(bid);
    }
}