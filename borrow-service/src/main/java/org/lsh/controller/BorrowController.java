package org.lsh.controller;

import org.lsh.entity.UserBorrowDetail;
import org.lsh.service.BorrowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;

@RestController
public class BorrowController {

    @Resource
    BorrowService service;

    @RequestMapping("/borrow/{uid}")
    UserBorrowDetail findUserBorrows(@PathVariable("uid") int uid) {
        return service.getUserBorrowDetailByUid(uid);
    }

    // 备选方案
    // 主要参数和返回值要和上面一致
    UserBorrowDetail onError(int uid){
        return new UserBorrowDetail(null, Collections.emptyList());
    }
}
