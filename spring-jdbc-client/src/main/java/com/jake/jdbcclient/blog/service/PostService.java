package com.jake.jdbcclient.blog.service;

import com.jake.jdbcclient.blog.dto.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> findAll();

    Optional<Post> findById(String id);

    void create(Post post);

    void update(Post post, String id);

    void delete(String id);
}
