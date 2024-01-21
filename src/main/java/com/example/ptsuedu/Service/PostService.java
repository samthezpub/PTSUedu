package com.example.ptsuedu.Service;


import com.example.ptsuedu.Entity.Post;

public interface PostService {

    void addPost(Post post);
    void deletePost(Post post);
    Post getPostById(Long id);

    // TODO
    //List<Post> getAllPosts();
}
