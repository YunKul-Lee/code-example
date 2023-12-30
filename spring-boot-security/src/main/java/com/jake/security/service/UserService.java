package com.jake.security.service;

import com.jake.security.dto.UserDto;
import com.jake.security.model.User;

public interface UserService {

    User findByUsername(String username);

    User save(UserDto userDto);
}
