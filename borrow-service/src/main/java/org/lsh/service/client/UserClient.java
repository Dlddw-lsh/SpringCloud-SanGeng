package org.lsh.service.client;

import com.lsh.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// 声明为userService服务的HTTP请求客户端
@FeignClient("userService")
public interface UserClient {
    @RequestMapping("/user/{uid}")
    User findUserById(@PathVariable("uid") int uid);
}
