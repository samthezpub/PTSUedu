<<<<<<<< HEAD:src/main/java/com/example/ptsuedu/repository/PostRepository.java
package com.example.ptsuedu.repository;


import com.example.ptsuedu.entity.Post;
========
package com.example.pstuedu.repository;


import com.example.pstuedu.entity.Post;
>>>>>>>> master:src/main/java/com/example/pstuedu/repository/PostRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
