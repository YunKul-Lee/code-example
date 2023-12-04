package com.jake.jdbcclient.blog.service;

import com.jake.jdbcclient.blog.dto.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JdbcClientPostService implements PostService {

    private final JdbcClient jdbcClient;

    public JdbcClientPostService(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public List<Post> findAll() {
        return jdbcClient.sql("SELECT * FROM post")
                .query(Post.class)
                .list();
    }

    @Override
    public Optional<Post> findById(String id) {
        return jdbcClient.sql("SELECT * FROM post WHERE id = :id")
                .param("id", id)
                .query(Post.class)
                .optional();
    }

    @Override
    public void create(Post post) {
        int inserted = jdbcClient.sql("INSERT INTO post(id, title, slug, date, time_to_read, tags) values (?, ?, ?, ?, ?, ?)")
                .params(List.of(post.getId(), post.getTitle(), post.getSlug(), post.getDate(), post.getTimeToRead(), post.getTags()))
                .update();

        Assert.state(inserted == 1, "Post Create Fail!! " + post.getTitle());
    }

    @Override
    public void update(Post post, String id) {
        int updated = jdbcClient.sql("UPDATE post SET title = ?, slug = ?, date = ?, time_to_read = ?, tags = ? WHERE id = ?")
                .params(List.of(post.getTitle(), post.getSlug(), post.getDate(), post.getTimeToRead(), post.getTags(), id))
                .update();

        Assert.state(updated == 1, "Post Update Fail!! " + post.getTitle());
    }

    @Override
    public void delete(String id) {
        int deleted = jdbcClient.sql("DELETE FROM post WHERE id = :id")
                .param("id", id)
                .update();

        Assert.state(deleted == 1, "Post Delete Fail!! " + id);
    }
}
