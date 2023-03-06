package com.board.test.domain.dto.post;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ResponsePostDto {

    public ResponsePostDto() {}

    public ResponsePostDto(String title, String name, LocalDateTime created) {
        this.title = title;
        this.name = name;
        this.created = created;
    }

    private String title;
    private String name;
    private LocalDateTime created;
}
