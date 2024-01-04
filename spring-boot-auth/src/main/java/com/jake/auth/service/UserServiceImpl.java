package com.jake.auth.service;

import com.jake.auth.dto.UserDto;
import com.jake.auth.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User save(UserDto userDto) {
        return null;
    }
}
