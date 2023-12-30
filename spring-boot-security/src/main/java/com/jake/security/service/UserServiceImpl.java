package com.jake.security.service;

import com.jake.security.dto.UserDto;
import com.jake.security.model.User;
import com.jake.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepo;

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public User save(UserDto userDto) {
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        User user = User.createUser(userDto.getUsername(), encodedPassword, userDto.getFullname());

        return userRepo.save(user);
    }
}
