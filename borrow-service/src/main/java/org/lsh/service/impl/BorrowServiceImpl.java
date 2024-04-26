package org.lsh.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lsh.entity.Book;
import com.lsh.entity.Borrow;
import com.lsh.entity.User;
import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.lsh.entity.UserBorrowDetail;
import org.lsh.mapper.BorrowMapper;
import org.lsh.service.BorrowService;
import org.lsh.service.client.BookClient;
import org.lsh.service.client.UserClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BorrowServiceImpl implements BorrowService {

    @Resource
    BorrowMapper mapper;

    @Resource
    UserClient userClient;

    @Resource
    BookClient bookClient;

    @Override
    @SentinelResource(value = "getUserDetail", blockHandler = "blocked")
    public UserBorrowDetail getUserBorrowDetailByUid(int uid) {
        List<Borrow> borrow = mapper.getBorrowsByUid(uid);
        //这里通过调用getForObject来请求其他服务，并将结果自动进行封装
        //获取User信息
        User user = userClient.getUserById(uid);
        //获取每一本书的详细信息
        List<Book> bookList = borrow
                .stream()
                .map(b -> bookClient.findBookById(b.getBid()))
                .collect(Collectors.toList());
        return new UserBorrowDetail(user, bookList);
    }

    // 替代方法, 参数要和需要替代的保持一直，后面还要一个BlockException
    public UserBorrowDetail blocked(int uid, BlockException e) {
        log.error(e.getLocalizedMessage());
        return new UserBorrowDetail(null, Collections.emptyList());
    }
}