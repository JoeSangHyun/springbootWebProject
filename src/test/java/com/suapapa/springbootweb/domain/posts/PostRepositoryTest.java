package com.suapapa.springbootweb.domain.posts;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @After // 1)
    public void cleanUp() {
        postRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트게시글";
        String content = "테스트본문";

        postRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("suapapa@naver.com")
                .build()); //2)

        // when
        List<Posts> postsList = postRepository.findAll(); // 3)

        // then
        Posts posts = postsList.get(0);
        Assertions.assertThat(posts.getTitle()).isEqualTo(title);
        Assertions.assertThat(posts.getContent()).isEqualTo(content);

    }
}