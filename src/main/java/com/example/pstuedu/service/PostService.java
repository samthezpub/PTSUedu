package com.example.pstuedu.service;


import com.example.pstuedu.entity.Post;

public interface PostService {

    void addPost(Post post);
    void deletePost(Post post);
    Post getPostById(Long id);

    // TODO
    //List<Post> getAllPosts();
}
