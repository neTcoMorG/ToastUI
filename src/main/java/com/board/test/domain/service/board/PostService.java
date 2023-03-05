package com.board.test.domain.service.board;

import com.board.test.domain.dto.post.CreatePostDto;
import com.board.test.domain.entity.Post;
import com.board.test.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getPosts () {
        return postRepository.findAll();
    }

    public Long addPost (CreatePostDto dto) {
        return postRepository.save(dto.toEntity()).getId();
    }

    public void removePost (Long postId, String password) {
        Post findPost = postRepository.findById(postId).orElseThrow();
        if (findPost.validPassword(password)) {
            postRepository.delete(findPost);
            return;
        }
        throw new IllegalStateException("패스워드 오류");
    }
}
