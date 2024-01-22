package com.example.ptsuedu.Controller;

import com.example.ptsuedu.Entity.Group;
import com.example.ptsuedu.Exception.GroupNotFoundException;
import com.example.ptsuedu.Exception.GroupNotUniqueException;
import com.example.ptsuedu.Service.Implementation.GroupServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/groups")
public class GroupController {
    private final GroupServiceImplementation groupService;

    @PostMapping("/create")
    public ResponseEntity<?> createGroup(@RequestBody Group group){
        try {
            groupService.createGroup(group);

            String serverAnswer = String.format("Группа %s создана!", group.getName());
            return new ResponseEntity<>(serverAnswer, HttpStatus.CREATED);
        } catch (GroupNotUniqueException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getGroup(@RequestParam Long id){
        try {
            return new ResponseEntity<>(groupService.findGroupById(id), HttpStatus.OK) ;
        } catch (GroupNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
