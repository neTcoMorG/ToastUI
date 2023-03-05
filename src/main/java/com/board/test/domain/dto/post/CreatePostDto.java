package com.board.test.domain.dto.post;

import com.board.test.domain.entity.Post;
import lombok.Getter;

@Getter
public class CreatePostDto {

    private String name;
    private String content;
    private String title;

    public Post toEntity () {
        return new Post(title, content, name);
    }
}
