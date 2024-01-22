package com.example.ptsuedu.service.Implementation;

import com.example.ptsuedu.Entity.Group;
import com.example.ptsuedu.exception.GroupNotFoundException;
import com.example.ptsuedu.exception.GroupNotUniqueException;
import com.example.ptsuedu.repository.GroupRepository;
import com.example.ptsuedu.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GroupServiceImplementation implements GroupService {

    private final GroupRepository groupRepository;
    @Override
    public void createGroup(Group group) throws GroupNotUniqueException {
        if (groupRepository.findGroupByName(group.getName()).isEmpty()){
            throw new GroupNotUniqueException("Данная группа уже существует!");
        }
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
        Group group = findGroupById(id);

        groupRepository.delete(group);
    }
}
