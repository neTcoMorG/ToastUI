package com.board.test.web;

import com.board.test.domain.dto.post.CreatePostDto;
import com.board.test.domain.dto.post.ResponsePostDto;
import com.board.test.domain.service.board.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final PostService postService;

    @GetMapping
    public List<ResponsePostDto> getAll () {
        List<ResponsePostDto> result = new ArrayList<>();
        ResponsePostDto dummy = new ResponsePostDto();

        postService.getPosts().forEach(post -> {
            result.add(new ResponsePostDto(post.getTitle(), post.getName(),
                    post.getCreated()));
        });
        return result;
    }

    @PostMapping("/add")
    public HttpEntity<?> createPost (@RequestBody CreatePostDto dto) {
        postService.addPost(dto);

        log.info(dto.getTitle());
        log.info(dto.getContent());
        return ResponseEntity.ok().build();
    }

    @GetMapping("{uuid}")
    public HttpEntity<?> getPostById (@PathVariable String uuid) {
        return ResponseEntity.ok(postService.getPost(uuid));
    }
}
