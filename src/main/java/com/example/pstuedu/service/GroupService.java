package com.example.pstuedu.service;

import com.example.pstuedu.entity.Group;
import com.example.pstuedu.exception.GroupNotFoundException;

public interface GroupService {
    void createGroup(Group group);

    Group findGroupById(Long id) throws GroupNotFoundException;

    void deleteGroupById(Long id);
}
