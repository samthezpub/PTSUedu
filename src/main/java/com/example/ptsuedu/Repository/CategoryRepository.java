package com.example.ptsuedu.Repository;

import com.example.ptsuedu.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Subject, Long> {
}
