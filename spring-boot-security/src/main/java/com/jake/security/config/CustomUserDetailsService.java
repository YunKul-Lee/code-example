package com.jake.security.config;

import com.jake.security.config.CustomUserDetails;
import com.jake.security.model.User;
import com.jake.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("Username not found");
        }

        return new CustomUserDetails(user.getUsername(), user.getPassword(), authorities(), user.getFullname());
    }

    private Collection<? extends GrantedAuthority> authorities() {
        return List.of(new SimpleGrantedAuthority("USER"));
    }
}
