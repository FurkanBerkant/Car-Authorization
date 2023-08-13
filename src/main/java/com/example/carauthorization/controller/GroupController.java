package com.example.carauthorization.controller;

import com.example.carauthorization.model.Company;
import com.example.carauthorization.model.Group;
import com.example.carauthorization.service.abstracts.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/groups")
@AllArgsConstructor
public class GroupController {
    private final GroupService groupService;
    @GetMapping
    public ResponseEntity<List<Group>> getAllGroup() {
        return new ResponseEntity<>(groupService.getAllGroups(), HttpStatus.OK);
    }
    @GetMapping("/{groupId}")
    public ResponseEntity<Group>getOneGroup(@PathVariable Long groupId) {
        Group group = groupService.getGroupById(groupId).orElse(null);
        if(group == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(group,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Group> createCompany(@RequestBody Group createGroup) {
        Group group= groupService.createGroup(createGroup);
        return ResponseEntity.status(HttpStatus.CREATED).body(group);
    }
    @PutMapping("/{groupId}")
    public ResponseEntity<Group> updateGroup(@PathVariable Long groupId, @RequestBody Group group) {
        Group updatedGroup = groupService.updateGroup(groupId, group);
        return ResponseEntity.ok(updatedGroup);
    }
    @DeleteMapping("/{groupId}")
    public ResponseEntity<Void> deleteGroup(@PathVariable Long groupId) {
        groupService.deleteGroup(groupId);
        return ResponseEntity.noContent().build();
    }



}
