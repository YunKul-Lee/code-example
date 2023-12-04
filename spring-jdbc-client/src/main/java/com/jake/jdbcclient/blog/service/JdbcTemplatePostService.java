package com.jake.jdbcclient.blog.service;

import com.jake.jdbcclient.blog.dto.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class JdbcTemplatePostService implements PostService {

    private final JdbcTemplate jdbcTemplate;

    private RowMapper<Post> postRowMapper = (rs, rowNum) -> new Post(
      rs.getString("id"),
      rs.getString("title"),
      rs.getString("slug"),
      rs.getDate("date").toLocalDate(),
      rs.getInt("time_to_read"),
      rs.getString("tags")
    );

    public JdbcTemplatePostService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Post> findAll() {
        String sql = "SELECT * FROM post";

        return jdbcTemplate.query(sql, postRowMapper);
    }

    @Override
    public Optional<Post> findById(String id) {
        String sql = "SELECT * FROM post WHERE id = ?";
        Post post = jdbcTemplate.queryForObject(sql, postRowMapper, id);

        return Optional.ofNullable(post);
    }

    @Override
    public void create(Post post) {
        String sql = "INSERT INTO post(id, title, slug, date, time_to_read, tags) values(?, ?, ?, ?, ?, ?)";
        int insert = jdbcTemplate.update(sql, post.getId(), post.getTitle(), post.getSlug(), post.getDate(), post.getTimeToRead(), post.getTags());
    }

    @Override
    public void update(Post post, String id) {
        String sql = "UPDATE post SET title = ?, slug = ?, date = ?, time_to_read=?, tags=? WHERE id = ?";
        int update = jdbcTemplate.update(sql, post.getTitle(), post.getSlug(), post.getDate(), post.getTimeToRead(), post.getTags(), id);

        log.info("Post Updated: {} {}", update, post.getTitle());
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM post WHERE id = ?";
        int delete = jdbcTemplate.update(sql, id);

        log.info("Post Deleted: {} {}", delete, id);
    }
}
