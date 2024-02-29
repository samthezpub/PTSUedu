package com.example.pstuedu.service;

import com.example.pstuedu.entity.Subject;
import com.example.pstuedu.exception.SubjectNotFoundException;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    void createSubject(Subject subject);

    Subject findSubject(Long id) throws SubjectNotFoundException;
    Subject findSubject(String name) throws SubjectNotFoundException;

    void updateSubject(Subject newSubject);

    void deleteSubject(Long id) throws SubjectNotFoundException;
    void deleteSubject(Subject subject);

    List<Subject> getAll();
}
