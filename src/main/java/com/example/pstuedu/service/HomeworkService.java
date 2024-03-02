package com.example.pstuedu.service;

import com.example.pstuedu.entity.Homework;
import com.example.pstuedu.exception.HomeworkNotFoundException;
import com.example.pstuedu.repository.HomeworkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HomeworkService {
    void createHomework(Homework homework);
    Homework findHomework(Long id) throws HomeworkNotFoundException;
    void updateHomework(Homework homework);

    void deleteHomework(Long id);
}
