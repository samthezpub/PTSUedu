<<<<<<<< HEAD:src/main/java/com/example/ptsuedu/service/SubjectService.java
package com.example.ptsuedu.service;

import com.example.ptsuedu.entity.Subject;
========
package com.example.pstuedu.service;

import com.example.pstuedu.entity.Subject;
>>>>>>>> master:src/main/java/com/example/pstuedu/service/SubjectService.java

public interface SubjectService {
    void createSubject(Subject subject);

    void findSubject(Long id);
    void findSubject(String name);

    void updateSubject(Subject newSubject);

    void deleteSubject(Long id);
    void deleteSubject(Subject subject);
}
