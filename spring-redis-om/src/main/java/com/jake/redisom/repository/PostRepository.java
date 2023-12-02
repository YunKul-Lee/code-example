package com.jake.redisom.repository;

import com.jake.redisom.model.Post;
import com.redis.om.spring.repository.RedisDocumentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends RedisDocumentRepository<Post, String> {

    List<Post> findByClapCountBetween(int minClap, int maxClap);

    List<Post> findByAuthor_NameAndAuthor_LastName(String name, String lastName);

    List<Post> searchByContent(String text);

    List<Post> findByComments_Content(String content);
}
