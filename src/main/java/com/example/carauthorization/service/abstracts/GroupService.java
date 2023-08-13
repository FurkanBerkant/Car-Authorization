package com.example.carauthorization.service.abstracts;

import com.example.carauthorization.model.Group;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    public List<Group> getAllGroups();
    public Optional<Group> getGroupById(Long groupId);
    public Group createGroup(Group group);
    public Group updateGroup(Long groupId, Group updatedGroup);
    public void deleteGroup(Long groupId);

}
