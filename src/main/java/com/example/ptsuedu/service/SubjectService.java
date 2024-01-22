package com.example.ptsuedu.service;

import com.example.ptsuedu.entity.Subject;

public interface SubjectService {
    void createSubject(Subject subject);

    void findSubject(Long id);
    void findSubject(String name);

    void updateSubject(Subject newSubject);

    void deleteSubject(Long id);
    void deleteSubject(Subject subject);
}
