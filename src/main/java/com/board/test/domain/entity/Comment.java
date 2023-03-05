package com.board.test.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

    public Comment(Post post, String content, String password) {
        this.post = post;
        this.content = content;
        this.password = password;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

    @ManyToOne @JoinColumn(name = "POST_ID") private Post post;

    private String content;
    private String password;

    @CreatedDate private LocalDateTime created;

    public void update (String content) {
        this.content = content;
        created = LocalDateTime.now();
    }

    public boolean validPassword(String password) {
        return this.password.equals(password);
    }

    protected void setPost(Post post) {
        this.post = post;
    }
}
