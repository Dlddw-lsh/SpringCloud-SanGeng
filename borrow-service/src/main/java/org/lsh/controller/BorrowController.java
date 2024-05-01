package org.lsh.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lsh.entity.Result;
import jakarta.annotation.Resource;
import org.lsh.entity.UserBorrowDetail;
import org.lsh.service.BorrowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class BorrowController {

    @Resource
    BorrowService service;

    @RequestMapping("/borrow/{uid}")
    UserBorrowDetail findUserBorrows(@PathVariable("uid") int uid) {
        return service.getUserBorrowDetailByUid(uid);
    }

    @RequestMapping("/blocked")
    public Result<String> blocked() {
        return Result.ok("请求频率过快");
    }

    @RequestMapping("/test")
    @SentinelResource(
            value = "test",
            fallback = "except",
            blockHandler = "block",
            exceptionsToIgnore = IOException.class)
    public String test() {
        throw new RuntimeException("Hello World");
    }

    @RequestMapping("/test2")
    @SentinelResource("test2")
    String findUserBorrow2(@RequestParam(value = "a", required = false) String a,
                           @RequestParam(value = "b", required = false) String b,
                           @RequestParam(value = "c", required = false) String c) {
        return "请求成功：" + "a=" + a + ",b=" + b + ",c=" + c;
    }

    // 替代方法名必须和原方法参数一致，最后可以添加一个Throwable作为参数接收异常
    String except(Throwable t) {
        return t.getMessage();
    }

    // 如果blockHandler和fallback都指定了，出现限流的异常就走block，其他异常走fallback
    String block(BlockException e) {
        return "被限流了";
    }
}
