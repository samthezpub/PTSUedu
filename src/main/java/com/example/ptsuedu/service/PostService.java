package com.example.ptsuedu.service;

import com.example.ptsuedu.entity.Post;

import java.util.List;

public interface PostService {

    void addPost(Post post);
    void deletePost(Post post);
    Post getPostById(Long id);

    // TODO
    //List<Post> getAllPosts();
}
