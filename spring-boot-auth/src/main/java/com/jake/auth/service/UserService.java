package com.jake.auth.service;

import com.jake.auth.dto.UserDto;
import com.jake.auth.model.User;

public interface UserService {

    User findByUsername(String username);

    User save(UserDto userDto);
}
