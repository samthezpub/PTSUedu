package com.example.ptsuedu.Service;

import com.example.ptsuedu.Entity.Group;
import com.example.ptsuedu.Exception.GroupNotFoundException;
import com.example.ptsuedu.Exception.GroupNotUniqueException;

public interface GroupService {
    void createGroup(Group group) throws GroupNotUniqueException;

    Group findGroupById(Long id) throws GroupNotFoundException;

    void deleteGroup(Long id) throws GroupNotFoundException;
}
