package org.example.service;

import org.example.domain.Post;

import java.util.List;

public interface PostService {
    void deletePost(int id);

    Post findPostById(int id);

    List<Post> findAllPosts();

    Post savePost(Post post);
}
