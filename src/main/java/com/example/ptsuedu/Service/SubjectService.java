package com.example.ptsuedu.Service;

import com.example.ptsuedu.Entity.Subject;

public interface SubjectService {
    void createSubject(Subject subject);

    void findSubject(Long id);
    void findSubject(String name);

    void updateSubject(Subject newSubject);

    void deleteSubject(Long id);
    void deleteSubject(Subject subject);
}
