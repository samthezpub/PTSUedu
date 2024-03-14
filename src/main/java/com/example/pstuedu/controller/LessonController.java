package com.example.pstuedu.controller;

import com.example.pstuedu.entity.Homework;
import com.example.pstuedu.entity.Lesson;
import com.example.pstuedu.exception.LessonNotFoundException;
import com.example.pstuedu.service.LessonService;
import com.example.pstuedu.service.implementation.HomeworkServiceImplementation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/lessons")

@CrossOrigin(origins = "http://localhost:3000")
public class LessonController {

    private LessonService lessonService;
    private final HomeworkServiceImplementation homeworkService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllLessons() {
        return new ResponseEntity<>(lessonService.findAllLessons(), HttpStatus.FOUND);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getLesson(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(lessonService.findLessonById(id), HttpStatus.FOUND);

        } catch (LessonNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/{lesson_id}/homework")
    public ResponseEntity<?> getHomework(@PathVariable Long lesson_id) {
        try {
            Lesson lessonById = lessonService.findLessonById(lesson_id);
            return new ResponseEntity<>(lessonById.getHomework(), HttpStatus.OK);
        } catch (LessonNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/get/{lesson_id}/homework/create")
    public ResponseEntity<?> createHomework(@PathVariable Long lesson_id, @RequestBody Homework homework) {
        // Получаем Lesson и присваиваем Homework Lesson
        Lesson lessonById;

        try {
            // Получение
            lessonById = lessonService.findLessonById(lesson_id);

            // устанавливаем домашке урок
            // Если у урока уже есть домашка ошибочка
            if (lessonById.getHomework() != null){
                return new ResponseEntity<>("У этого урока уже есть домашка", HttpStatus.CONFLICT);
            }
            homework.setLesson(lessonById);
        } catch (LessonNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        // Создаём домашку в бд
        homeworkService.createHomework(homework);

        // Устанавливаем домашку уроку
        lessonById.setHomework(homework);
        // Обновляем урок
        lessonService.updateLesson(lessonById);

        return new ResponseEntity<>("Задание успешно создано!", HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<?> createLesson(@RequestBody Lesson lesson) {
        try {
            lessonService.createLesson(lesson);

            String serverAnswer = String.format("Урок %s создан!", lesson.getTitle());
            return new ResponseEntity<>(serverAnswer, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteLesson(@PathVariable Long id) {
        try {
            Lesson lesson = lessonService.findLessonById(id);
            lessonService.deleteLesson(id);

            String serverAnswer = String.format("Урок %s удалён!", lesson.getTitle());
            return new ResponseEntity<>(serverAnswer, HttpStatus.CREATED);

        } catch (LessonNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }


}
