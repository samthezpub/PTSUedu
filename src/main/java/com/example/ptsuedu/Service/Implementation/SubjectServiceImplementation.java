package com.example.ptsuedu.Service.Implementation;

import com.example.ptsuedu.Entity.Subject;
import com.example.ptsuedu.Repository.SubjectRepository;
import com.example.ptsuedu.Service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectServiceImplementation implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Override
    public void createSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    @Override
    public void findSubject(Long id) {

    }

    @Override
    public void findSubject(String name) {

    }

    @Override
    public void updateSubject(Subject newSubject) {

    }

    @Override
    public void deleteSubject(Long id) {

    }

    @Override
    public void deleteSubject(Subject subject) {

    }
}
