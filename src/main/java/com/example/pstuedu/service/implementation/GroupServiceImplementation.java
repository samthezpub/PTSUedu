package com.example.pstuedu.service.implementation;

import com.example.pstuedu.entity.Group;
import com.example.pstuedu.exception.GroupNotFoundException;
import com.example.pstuedu.repository.GroupRepository;
import com.example.pstuedu.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GroupServiceImplementation implements GroupService {

    private final GroupRepository groupRepository;

    @Override
    public void createGroup(Group group) {
        groupRepository.save(group);
    }

    @Override
    public Group findGroupById(Long id) throws GroupNotFoundException {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new GroupNotFoundException("Группа не найдена!"));
        return group;
    }

    @Override
    public void deleteGroupById(Long id) {
        groupRepository.deleteById(id);
    }
}
