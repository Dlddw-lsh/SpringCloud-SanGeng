package org.lsh.service.client;

import com.lsh.entity.User;
import org.lsh.service.client.impl.UserFallbackClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// 声明为userService服务的HTTP请求客户端, fallback指定补救措施
@FeignClient(value = "userService", fallback = UserFallbackClient.class)
public interface UserClient {
    @RequestMapping("/user/{uid}")
    User findUserById(@PathVariable("uid") int uid);
}
