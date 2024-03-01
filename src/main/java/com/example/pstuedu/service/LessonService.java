package com.example.pstuedu.service;

import com.example.pstuedu.entity.Lesson;
import com.example.pstuedu.exception.LessonNotFoundException;

import java.util.List;

public interface LessonService {
    void createLesson(Lesson lesson);

    Lesson findLessonById(Long id) throws LessonNotFoundException;

    void updateLesson(Lesson lesson);

    void deleteLesson(Long id) throws LessonNotFoundException;
    List<Lesson> findAllLessons();
}
