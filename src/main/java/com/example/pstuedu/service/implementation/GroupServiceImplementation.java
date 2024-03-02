package com.example.pstuedu.service.implementation;

import com.example.pstuedu.entity.Group;
import com.example.pstuedu.entity.User;
import com.example.pstuedu.exception.GroupNotFoundException;
import com.example.pstuedu.exception.GroupNotUniqueException;
import com.example.pstuedu.exception.UserAlreadyHaveGroupException;
import com.example.pstuedu.exception.UserNotFoundException;
import com.example.pstuedu.repository.GroupRepository;
import com.example.pstuedu.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GroupServiceImplementation implements GroupService {

    private final GroupRepository groupRepository;

    private final UserServiceImplementation userService;

    @Override
    public void createGroup(Group group) throws GroupNotUniqueException {
        if (!groupRepository.findGroupByName(group.getName()).isEmpty()) {
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
    public void updateGroup(Group group) {
            // Волшебная штука, которая обновляет
            groupRepository.save(group);
    }


    // Устанавливает юзеру группу, а группе плюсует юзера
    @Override
    public void addUserToGroup(Long userId, Long groupId) throws UserNotFoundException, GroupNotFoundException, UserAlreadyHaveGroupException {

        // Получаем юзера и группу
        User userById = userService.findUserById(userId);
        Group groupById = findGroupById(groupId);

        userById.setGroup(groupById);

        // Получаю лист юзеров группы и добавляю юзера
        List<User> groupUsers = groupById.getUsers();
        groupUsers.add(userById);

        // Если юзера нет в группах
        if (groupUsers.contains(userById)){
            throw new UserAlreadyHaveGroupException("У пользователя уже есть группа!");
        }

        // Устанавливаю юзеров и провожу апдейт
        groupById.setUsers(groupUsers);
        updateGroup(groupById);
        userService.updateUser(userById);
    }

    @Override
    public void deleteGroupById(Long id) throws GroupNotFoundException {
        Group group = findGroupById(id);

        groupRepository.delete(group);
    }
}
