<<<<<<<< HEAD:src/main/java/com/example/ptsuedu/service/PostService.java
package com.example.ptsuedu.service;


import com.example.ptsuedu.entity.Post;
========
package com.example.pstuedu.service;


import com.example.pstuedu.entity.Post;
>>>>>>>> master:src/main/java/com/example/pstuedu/service/PostService.java

public interface PostService {

    void addPost(Post post);
    void deletePost(Post post);
    Post getPostById(Long id);

    // TODO
    //List<Post> getAllPosts();
}
