package com.example.ptsuedu.service;

import com.example.ptsuedu.entity.Group;
import com.example.ptsuedu.exception.GroupNotFoundException;
import com.example.ptsuedu.exception.GroupNotUniqueException;

public interface GroupService {
    void createGroup(Group group) throws GroupNotUniqueException;

    Group findGroupById(Long id) throws GroupNotFoundException;

    void deleteGroup(Long id) throws GroupNotFoundException;
}
