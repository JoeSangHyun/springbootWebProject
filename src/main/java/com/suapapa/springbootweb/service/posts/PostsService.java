package com.suapapa.springbootweb.service.posts;

import com.suapapa.springbootweb.domain.posts.PostRepository;
import com.suapapa.springbootweb.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postRepository.save(requestDto.toEntity()).getId();
    }
}
