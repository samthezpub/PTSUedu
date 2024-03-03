package com.example.pstuedu.service.implementation;

import com.example.pstuedu.entity.Grade;
import com.example.pstuedu.exception.GradeNotFoundException;
import com.example.pstuedu.repository.GradeRepository;
import com.example.pstuedu.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GradeServiceImplementation implements GradeService {

    private final GradeRepository gradeRepository;

    @Override
    public void createGrade(Grade grade) {
        gradeRepository.save(grade);
    }

    @Override
    public Grade findGrade(Long id) throws GradeNotFoundException {
        return gradeRepository.findById(id).orElseThrow(()-> new GradeNotFoundException("Домашняя работа не найдена!"));
    }

    @Override
    public void updateGrade(Grade grade) {
        gradeRepository.save(grade);
    }

    @Override
    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }
}
