package com.example.pstuedu.controller;

import com.example.pstuedu.entity.Subject;
import com.example.pstuedu.exception.SubjectNotFoundException;
import com.example.pstuedu.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private SubjectService subjectService;

    @GetMapping("/get-all")
    public List<Subject> getSubjects() {
        return subjectService.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createSubject(@RequestBody Subject subject) {
        try {
            subjectService.createSubject(subject);

            String serverAnswer = String.format("Предмет %s создан!", subject.getName());
            return new ResponseEntity<>(serverAnswer, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable Long id) {
        try {
            Subject subject = subjectService.findSubject(id);

            String serverAnswer = String.format("Предмет %s удалён!", subject.getName());
            return new ResponseEntity<>(serverAnswer, HttpStatus.CREATED);

        } catch (SubjectNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getSubjectById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(subjectService.findSubject(id), HttpStatus.FOUND);

        } catch (SubjectNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
