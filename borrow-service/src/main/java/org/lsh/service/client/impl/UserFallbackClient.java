package org.lsh.service.client.impl;

import com.lsh.entity.User;
import org.lsh.service.client.UserClient;
import org.springframework.stereotype.Component;

// OpenFeign实现服务降级
@Component
public class UserFallbackClient implements UserClient {

    @Override
    public User findUserById(int uid) {
        User user = new User();
        user.setName("我是补救措施");
        return user;
    }
}
