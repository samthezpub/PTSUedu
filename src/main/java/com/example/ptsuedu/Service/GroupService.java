package com.example.ptsuedu.Service;

import com.example.ptsuedu.Entity.Group;
import com.example.ptsuedu.Exception.GroupNotFoundException;

public interface GroupService {
    void createGroup(Group group);

    Group findGroupById(Long id) throws GroupNotFoundException;

    void deleteGroup(Long id) throws GroupNotFoundException;
}
