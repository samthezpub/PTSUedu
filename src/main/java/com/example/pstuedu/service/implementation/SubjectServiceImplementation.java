<<<<<<<< HEAD:src/main/java/com/example/ptsuedu/service/Implementation/SubjectServiceImplementation.java
package com.example.ptsuedu.service.Implementation;

import com.example.ptsuedu.entity.Subject;
import com.example.ptsuedu.repository.SubjectRepository;
import com.example.ptsuedu.service.SubjectService;
========
package com.example.pstuedu.service.implementation;

import com.example.pstuedu.entity.Subject;
import com.example.pstuedu.repository.SubjectRepository;
import com.example.pstuedu.service.SubjectService;
>>>>>>>> master:src/main/java/com/example/pstuedu/service/implementation/SubjectServiceImplementation.java
import lombok.RequiredArgsConstructor;
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
