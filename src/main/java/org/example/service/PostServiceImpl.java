package org.example.service;


import lombok.RequiredArgsConstructor;
import org.example.domain.*;
import org.example.domain.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public void deletePost(int id) {
        postRepository.deleteById(id);
    }

    @Override
    public Post findPostById(int id) {
        return postRepository.findPostById(id);
    }

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }
}


