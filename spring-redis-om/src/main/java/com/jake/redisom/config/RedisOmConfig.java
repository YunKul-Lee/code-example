package com.jake.redisom.config;

import com.jake.redisom.model.Author;
import com.jake.redisom.model.Comment;
import com.jake.redisom.model.Post;
import com.jake.redisom.repository.PostRepository;
import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Configuration
@EnableRedisDocumentRepositories(basePackages = "com.jake.redisom*")
@Slf4j
public class RedisOmConfig {

    /**
     * 데이터 초기화
     *
     */
    @Bean
    CommandLineRunner runner(PostRepository repo) {
        return args -> {

            repo.deleteAll();

            Date now = new Date();

            Author author1 = Author.builder()
                    .name("yunkul").lastName("lee")
                    .build();

            Author author2 = Author.builder()
                    .name("jiun").lastName("lee")
                    .build();

            String content1 = "Redis OM Spring Content1";
            String content2 = "Spring is a popular Framework";

            // Post 구성
            Post post1 = Post.builder()
                    .clapCount(50)
                    .title("What is Redis OM?")
                    .content(content1)
                    .comments(Set.of(Comment.builder().content("nice content").build()))
                    .createdDate(now)
                    .author(author1)
                    .ttl(100L)
                    .build();
            repo.save(post1);

            // Post 구성
            Post post2 = Post.builder()
                    .clapCount(60)
                    .title("What is Spring Framework?")
                    .content(content2)
                    .comments(Set.of(Comment.builder().content("so cool").build(), Comment.builder().content("good post").build()))
                    .createdDate(now)
                    .author(author2)
                    .ttl(100L)
                    .build();
            repo.save(post2);

            log.info("Posts Saved.");

            List<Post> postsByClapCount = repo.findByClapCountBetween(45, 55);
            log.info("postByClapCount: {}", postsByClapCount);

            List<Post> postsByAuthor = repo.findByAuthor_NameAndAuthor_LastName(author2.getName(), author2.getLastName());
            log.info("postByAuthor: {}", postsByAuthor);

            List<Post> postsSearchByContent = repo.searchByContent("popular Framework");
            log.info("postSearchByContent: {}", postsSearchByContent);

            List<Post> postsByCommentContent = repo.findByComments_Content("so cool");
            log.info("postsByCommentContent: {}", postsByCommentContent);
        };
    }
}
