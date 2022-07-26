package com.suapapa.springbootweb.domain.posts;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest // H2 데이터베이스를 자동으로 실행해 준다.
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @AfterEach // JUnit 에서 단위 테스트가 끝날때마다 수행되는 메소드를 지정
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