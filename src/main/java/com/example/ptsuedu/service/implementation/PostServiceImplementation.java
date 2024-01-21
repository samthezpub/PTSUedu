package com.example.ptsuedu.service.implementation;

import com.example.ptsuedu.entity.Post;
import com.example.ptsuedu.repository.PostRepository;
import com.example.ptsuedu.service.PostService;
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
