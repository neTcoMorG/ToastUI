package com.board.test.domain.service.board;

import com.board.test.domain.dto.post.CreateCommentDto;
import com.board.test.domain.entity.Comment;
import com.board.test.domain.entity.Post;
import com.board.test.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final PostRepository postRepository;

    public void addComment(CreateCommentDto dto) {
        Post post = getPostOrThrows(dto.getPostId());
        post.addComment(toCommentEntity(post, dto));
    }

    private Post getPostOrThrows (Long id) {
        return postRepository.findById(id).orElseThrow();
    }

    private Comment toCommentEntity (Post post, CreateCommentDto dto) {
        return new Comment(post, dto.getContent(), dto.getPassword());
    }
}
