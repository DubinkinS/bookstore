package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.Post;
import org.example.dto.PostRequestDTO;
import org.example.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<Post> getAll() {
        return postService.findAllPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getById(@PathVariable int id) {
        Post post = postService.findPostById(id);
        return post != null
                ? ResponseEntity.ok(post)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Post> create(@RequestBody PostRequestDTO dto) {
        Post post = Post.builder()
                .name(dto.getPostName())
                .salary(dto.getSalary())
                .build();

        return ResponseEntity.ok(postService.savePost(post));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
