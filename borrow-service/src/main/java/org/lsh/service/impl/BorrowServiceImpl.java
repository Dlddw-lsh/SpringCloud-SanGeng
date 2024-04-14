package org.lsh.service.impl;

import com.lsh.entity.Book;
import com.lsh.entity.Borrow;
import com.lsh.entity.User;
import org.lsh.entity.UserBorrowDetail;
import org.lsh.mapper.BorrowMapper;
import org.lsh.service.BorrowService;
import org.lsh.service.client.BookClient;
import org.lsh.service.client.UserClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Resource
    BorrowMapper mapper;

    @Resource
    UserClient userClient;

    @Resource
    BookClient bookClient;

    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(int uid) {
        List<Borrow> borrow = mapper.getBorrowsByUid(uid);
        //RestTemplate支持多种方式的远程调用
        //这里通过调用getForObject来请求其他服务，并将结果自动进行封装
        //获取User信息
        User user = userClient.findUserById(uid);
        //获取每一本书的详细信息
        List<Book> bookList = borrow
                .stream()
                .map(b -> bookClient.findBookById(uid))
                .collect(Collectors.toList());
        return new UserBorrowDetail(user, bookList);
    }
}