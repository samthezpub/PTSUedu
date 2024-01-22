package com.example.ptsuedu.repository;

import com.example.ptsuedu.Entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {
    @Query("SELECT g FROM Group g WHERE g.name = :name")
    public Optional<Group> findGroupByName(@Param("name") String name);
}
