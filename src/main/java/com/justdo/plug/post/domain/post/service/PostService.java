package com.justdo.plug.post.domain.post.service;

import com.justdo.plug.post.domain.post.Post;
import com.justdo.plug.post.domain.post.dto.PostRequestDto;
import com.justdo.plug.post.domain.post.dto.PostResponseDto;
import com.justdo.plug.post.domain.post.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);

    // BLOG003: 블로그 작성
    public Post save(PostRequestDto requestDto) {
       
            Post post = requestDto.toEntity();
            return postRepository.save(post);
    }

    // BLOG001: 블로그 리스트 조회
    public List<Post> getAllPosts() {

        return postRepository.findAll();

    }

    // BLOG002: 블로그 상세 페이지 조회
    public PostResponseDto getPostById(long post_id) {
        Post post = postRepository.findById(post_id)
                .orElseThrow(() -> new RuntimeException("해당 id의 게시글을 찾을 수 없습니다: " + post_id));



        String JsonContent = post.getContent();

        JSONArray jsonArray = new JSONArray(JsonContent);

        List<Object> list = jsonArray.toList();


        Object[] array = list.toArray();

        PostResponseDto responseDto =  PostResponseDto.builder()
                .post_id(post.getId())
                .title(post.getTitle())
                .content(array)
                .like_count(post.getLike_count())
                .temporary_state(post.isTemporary_state())
                .state(post.isState())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .member_id(post.getMember_id())
                .blog_id(post.getBlog_id())
                .build();

        System.out.println(jsonArray);
        System.out.println(responseDto);


        return responseDto;
    }

    // BLOG005: 블로그 삭제
    public String delete(long post_id){
        Post post = postRepository.findById(post_id)
                .orElseThrow(() -> new RuntimeException("해당 id의 게시글을 찾을 수 없습니다: " + post_id));
        postRepository.delete(post);

        return "게시글이 성공적으로 삭제되었습니다";
    }

    // 블로그 수정




}
