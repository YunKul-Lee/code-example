package com.jake.security.model;

import com.jake.security.dto.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public static User createUser(String username, String password, String fullname) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setFullname(fullname);

        return user;
    }

    private String username;
    private String password;
    private String fullname;
}
