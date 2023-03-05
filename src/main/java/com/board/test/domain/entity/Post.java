package com.board.test.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    public Post(String title, String content, String name) {
        this.title = title;
        this.content = content;
        this.name = name;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "post")
    private List<Comment> commentList = new ArrayList<>();
    private String title;
    private String content;
    private String password;
    private String name;
    @CreatedDate private LocalDateTime created;

    public void addComment (Comment comment) {
        commentList.add(comment);
        comment.setPost(this);
    }

    public boolean validPassword (String password) {
        return this.password.equals(password);
    }
}
