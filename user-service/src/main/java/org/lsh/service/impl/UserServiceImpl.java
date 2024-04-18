package org.lsh.service.impl;

import com.lsh.entity.User;
import jakarta.annotation.Resource;
import org.lsh.mapper.UserMapper;
import org.lsh.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper mapper;

    @Override
    public User getUserById(Integer uid) {
        return mapper.getUserById(uid);
    }
}
