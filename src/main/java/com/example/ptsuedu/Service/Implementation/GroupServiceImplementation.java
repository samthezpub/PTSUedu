package com.example.ptsuedu.Service.Implementation;

import com.example.ptsuedu.Entity.Group;
import com.example.ptsuedu.Exception.GroupNotFoundException;
import com.example.ptsuedu.Repository.GroupRepository;
import com.example.ptsuedu.Service.GroupService;
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
    public void deleteGroup(Long id) throws GroupNotFoundException {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new GroupNotFoundException("Группа не найдена!"));

        groupRepository.delete(group);
    }
}
