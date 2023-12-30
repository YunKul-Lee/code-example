package com.jake.security.repository;

import com.jake.security.dto.UserDto;
import com.jake.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


    User findByUsername(String username);

    User save(UserDto userDto);
}
