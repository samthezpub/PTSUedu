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
    public ResponseEntity<?> getHomework(@PathVariable Long lesson_id){
        try {
            Lesson lessonById = lessonService.findLessonById(lesson_id);
            return new ResponseEntity<>(lessonById.getHomework(), HttpStatus.OK);
        } catch (LessonNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //TODO сделать
    @PostMapping("/get/{lesson_id}/homework/create")
    public ResponseEntity<?> createHomework(@PathVariable Long lesson_id, @RequestBody Homework homework){
        homeworkService.createHomework(homework);

        try {
            Lesson lessonById = lessonService.findLessonById(lesson_id);
            lessonById.setHomework(homework);
            lessonService.updateLesson(lessonById);

            return new ResponseEntity<>("Задание успешно создано!", HttpStatus.OK);
        } catch (LessonNotFoundException e) {
            return new ResponseEntity<>("Урок не найден!", HttpStatus.NOT_FOUND);
        }
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
