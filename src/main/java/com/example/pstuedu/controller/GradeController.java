package com.example.pstuedu.controller;

import com.example.pstuedu.entity.Grade;
import com.example.pstuedu.entity.Homework;
import com.example.pstuedu.entity.User;
import com.example.pstuedu.exception.GradeNotFoundException;
import com.example.pstuedu.exception.HomeworkNotFoundException;
import com.example.pstuedu.exception.UserNotFoundException;
import com.example.pstuedu.service.implementation.GradeServiceImplementation;
import com.example.pstuedu.service.implementation.HomeworkServiceImplementation;
import com.example.pstuedu.service.implementation.UserServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/grades")
public class GradeController {
    private final GradeServiceImplementation gradeService;
    private final UserServiceImplementation userService;
    private final HomeworkServiceImplementation homeworkService;


    @PostMapping("/create/homework/{homework_id}/user/{user_id}")
    private ResponseEntity<?> createGrade(@RequestBody Grade grade, @PathVariable Long homework_id, @PathVariable Long user_id){
        try {
            // Установка User'a
            User userById = userService.findUserById(user_id);
            grade.setUser(userById);

            Homework homework = homeworkService.findHomework(homework_id);
            grade.setHomework(homework);

            gradeService.createGrade(grade);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (HomeworkNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Оценка успешно создана!", HttpStatus.CREATED);
    }





    @GetMapping("/get/{grade_id}")
    public ResponseEntity<?> getGrade(@PathVariable Long grade_id){
        try {
            Grade grade = gradeService.findGrade(grade_id);

            return new ResponseEntity<>(grade, HttpStatus.OK);
        } catch (GradeNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
