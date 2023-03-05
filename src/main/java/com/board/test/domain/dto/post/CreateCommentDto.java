package com.board.test.domain.dto.post;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateCommentDto {
    private String name;
    private String content;
    private String password;
    private Long postId;

}
