package com.example.pstuedu.service;

import com.example.pstuedu.entity.Subject;

public interface SubjectService {
    void createSubject(Subject subject);

    void findSubject(Long id);
    void findSubject(String name);

    void updateSubject(Subject newSubject);

    void deleteSubject(Long id);
    void deleteSubject(Subject subject);
}
