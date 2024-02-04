package com.example.pstuedu.service;

import com.example.pstuedu.entity.Group;
import com.example.pstuedu.exception.GroupNotFoundException;
import com.example.pstuedu.exception.GroupNotUniqueException;
import com.example.pstuedu.exception.UserNotFoundException;

public interface GroupService {
    void createGroup(Group group) throws GroupNotUniqueException;

    Group findGroupById(Long id) throws GroupNotFoundException;

    void addUserToGroup(Long userId, Long groupId) throws UserNotFoundException, GroupNotFoundException;

    void deleteGroupById(Long id) throws GroupNotFoundException;
}
