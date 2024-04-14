package org.lsh.service.impl;

import com.lsh.entity.Borrow;
import org.lsh.entity.UserBorrowDetail;
import org.lsh.mapper.BorrowMapper;
import org.lsh.service.BorrowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Resource
    BorrowMapper mapper;

    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(int uid) {
        List<Borrow> borrow = mapper.getBorrowsByUid(uid);
        //那么问题来了，现在拿到借阅关联信息了，怎么调用其他服务获取信息呢？
        return null;
    }
}