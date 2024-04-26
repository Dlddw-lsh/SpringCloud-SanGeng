package org.lsh.controller;

import com.lsh.entity.Result;
import jakarta.annotation.Resource;
import org.lsh.entity.UserBorrowDetail;
import org.lsh.service.BorrowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BorrowController {

    @Resource
    BorrowService service;

    @RequestMapping("/borrow/{uid}")
    UserBorrowDetail findUserBorrows(@PathVariable("uid") int uid) {
        return service.getUserBorrowDetailByUid(uid);
    }

    @RequestMapping("/blocked")
    public Result<String> blocked(){
        return Result.ok("请求频率过快");
    }
}
