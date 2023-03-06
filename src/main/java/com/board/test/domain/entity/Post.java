package com.board.test.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    public Post(String title, String content, String name) {
        this.title = title;
        this.content = content;
        this.name = name;
        uuid = RandomStringUtils.randomAlphanumeric(8);
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "post")
    private List<Comment> commentList = new ArrayList<>();
    private String uuid;
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
