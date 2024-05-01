package org.lsh.service.client;

import com.lsh.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientImpl implements UserClient {
    @Override
    public User getUserById(int uid) {
        User user = new User();
        user.setName("我是补救措施");
        return user;
    }
}
