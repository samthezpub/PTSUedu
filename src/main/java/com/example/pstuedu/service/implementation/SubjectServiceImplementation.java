package com.example.pstuedu.service.implementation;

import com.example.pstuedu.entity.Subject;
import com.example.pstuedu.exception.SubjectNotFoundException;
import com.example.pstuedu.repository.SubjectRepository;
import com.example.pstuedu.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectServiceImplementation implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Override
    public void createSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    @Override
    public Subject findSubject(Long id) throws SubjectNotFoundException {
        return subjectRepository.findById(id).orElseThrow(() -> new SubjectNotFoundException(String.format("Предмет с id %d не найден", id)));
    }

    @Override
    public Subject findSubject(String name) throws SubjectNotFoundException {
        return subjectRepository.findSubjectByName(name).orElseThrow(() -> new SubjectNotFoundException(String.format("Предмет с именем %s не найден", name)));
    }

    @Override
    public void updateSubject(Subject newSubject) {
        subjectRepository.save(newSubject);
    }

    @Override
    public void deleteSubject(Long id) throws SubjectNotFoundException {
        Subject subject = subjectRepository.findById(id).orElseThrow(() -> new SubjectNotFoundException(String.format("Предмет с id %d не найден", id)));
        subjectRepository.delete(subject);
    }

    @Override
    public void deleteSubject(Subject subject) {
        subjectRepository.delete(subject);
    }

    @Override
    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }
}
