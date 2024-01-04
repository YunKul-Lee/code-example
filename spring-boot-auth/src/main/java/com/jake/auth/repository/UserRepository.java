package com.jake.auth.repository;

import com.jake.auth.dto.UserDto;
import com.jake.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User save(UserDto userDto);
}
