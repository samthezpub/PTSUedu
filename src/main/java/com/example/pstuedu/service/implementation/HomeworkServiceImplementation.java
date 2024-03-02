package com.example.pstuedu.service.implementation;

import com.example.pstuedu.entity.Homework;
import com.example.pstuedu.exception.HomeworkNotFoundException;
import com.example.pstuedu.repository.HomeworkRepository;
import com.example.pstuedu.service.HomeworkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeworkServiceImplementation implements HomeworkService {

    private final HomeworkRepository homeworkRepository;

    @Override
    public void createHomework(Homework homework) {
        homeworkRepository.save(homework);
    }

    @Override
    public Homework findHomework(Long id) throws HomeworkNotFoundException {
        return homeworkRepository.findById(id).orElseThrow(()->new HomeworkNotFoundException("Домашняя работа не найдена!"));
    }

    @Override
    public void updateHomework(Homework homework) {
        homeworkRepository.save(homework);
    }

    @Override
    public void deleteHomework(Long id) {
        homeworkRepository.deleteById(id);
    }
}
