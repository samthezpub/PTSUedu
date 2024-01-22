<<<<<<<< HEAD:src/main/java/com/example/ptsuedu/service/Implementation/PostServiceImplementation.java
package com.example.ptsuedu.service.Implementation;

import com.example.ptsuedu.entity.Post;
import com.example.ptsuedu.repository.PostRepository;

import com.example.ptsuedu.service.PostService;
========
package com.example.pstuedu.service.implementation;

import com.example.pstuedu.entity.Post;
import com.example.pstuedu.repository.PostRepository;

import com.example.pstuedu.service.PostService;
>>>>>>>> master:src/main/java/com/example/pstuedu/service/implementation/PostServiceImplementation.java
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostServiceImplementation implements PostService {

    private PostRepository postRepository;

    @Override
    public void addPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void deletePost(Post post) {
        postRepository.delete(post);
    }

    @Override
    public Post getPostById(Long id) {
        // TODO
        return null;
    }
}
