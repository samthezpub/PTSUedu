package com.example.pstuedu.service.implementation;

import com.example.pstuedu.entity.Lesson;
import com.example.pstuedu.exception.LessonNotFoundException;
import com.example.pstuedu.repository.LessonRepository;
import com.example.pstuedu.service.LessonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LessonServiceImplementation implements LessonService {

    private LessonRepository lessonRepository;

    @Override
    public void createLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    @Override
    public Lesson findLessonById(Long id) throws LessonNotFoundException {
        return lessonRepository.findById(id).orElseThrow(() -> new LessonNotFoundException(String.format("Урок с id %d не найден!", id)));
    }

    @Override
    public void updateLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    @Override
    public void deleteLesson(Long id) throws LessonNotFoundException {
        lessonRepository.delete(lessonRepository.findById(id).orElseThrow(() -> new LessonNotFoundException(String.format("Урок с id %d не найден!", id))));
    }

    @Override
    public List<Lesson> findAllLessons() {
        return lessonRepository.findAll();
    }
}
