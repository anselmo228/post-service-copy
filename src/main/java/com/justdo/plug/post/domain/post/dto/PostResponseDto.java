package com.justdo.plug.post.domain.post.dto;
import lombok.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;

@Data
@Builder
public class PostResponseDto {
    private Long post_id;
    private String title;
    private Object[] content;
    private int like_count;
    private boolean temporary_state;
    private boolean state;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private long member_id;
    private long blog_id;

}
