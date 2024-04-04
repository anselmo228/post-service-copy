package com.justdo.plug.post.domain.post.service;

import com.justdo.plug.post.domain.post.Post;
import com.justdo.plug.post.domain.post.dto.PostRequestDto;
import com.justdo.plug.post.domain.post.dto.PostResponseDto;
import com.justdo.plug.post.domain.post.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    // 블로그 작성
    public Post save(PostRequestDto requestDto) {
       
            Post post = requestDto.toEntity();
            return postRepository.save(post);
    }

    public PostResponseDto getPostById(long post_id) {
        Post post = postRepository.findById(post_id)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + post_id));

        return PostResponseDto.builder()
                .post_id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .like_count(post.getLike_count())
                .temporary_state(post.isTemporary_state())
                .state(post.isState())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .member_id(post.getMember_id())
                .blog_id(post.getBlog_id())
                .build();
    }
}
