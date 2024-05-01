package org.lsh.service.client;

import com.lsh.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "userService", fallback = UserClientImpl.class)
public interface UserClient {

    @RequestMapping("/user/{uid}")
    User getUserById(@PathVariable int uid);
}
