package com.example.ptsuedu.Controller;

import com.example.ptsuedu.Entity.Group;
import com.example.ptsuedu.Exception.GroupNotFoundException;
import com.example.ptsuedu.Service.Implementation.GroupServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/groups")
public class GroupController {
    private final GroupServiceImplementation groupService;


    @GetMapping("/get")
    public ResponseEntity<?> getGroup(@RequestParam Long id){
        try {
            return new ResponseEntity<>(groupService.findGroupById(id), HttpStatus.OK) ;
        } catch (GroupNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
