package com.example.pstuedu.service;

import com.example.pstuedu.entity.Grade;
import com.example.pstuedu.exception.GradeNotFoundException;

public interface GradeService {
    void createGrade(Grade grade);
    Grade findGrade(Long id) throws GradeNotFoundException;
    void updateGrade(Grade grade);
    void deleteGrade(Long id);
}
