package org.lsh.service.client.impl;

import com.lsh.entity.Book;
import org.lsh.service.client.BookClient;
import org.springframework.stereotype.Component;

@Component
public class BookFallbackClient implements BookClient {
    @Override
    public Book findBookById(int bid) {
        return new Book();
    }
}
