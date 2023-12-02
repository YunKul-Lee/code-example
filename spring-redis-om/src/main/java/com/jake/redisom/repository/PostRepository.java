package com.jake.redisom.repository;

import com.jake.redisom.model.Post;
import com.redis.om.spring.repository.RedisDocumentRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends RedisDocumentRepository<Post, String> {


}
