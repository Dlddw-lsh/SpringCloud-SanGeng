package org.lsh.service.client;

import com.lsh.entity.Book;
import org.lsh.service.client.impl.BookFallbackClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "bookService", fallback = BookFallbackClient.class)
public interface BookClient {

    @RequestMapping("/book/{bid}")
    Book findBookById(@PathVariable("bid") int bid);
}
