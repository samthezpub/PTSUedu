package com.example.pstuedu.controller;

import com.example.pstuedu.entity.Lesson;
import com.example.pstuedu.exception.LessonNotFoundException;
import com.example.pstuedu.service.LessonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    private LessonService lessonService;

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
