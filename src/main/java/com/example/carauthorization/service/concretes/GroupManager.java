package com.example.carauthorization.service.concretes;

import com.example.carauthorization.model.Group;
import com.example.carauthorization.repository.GroupRepository;
import com.example.carauthorization.service.abstracts.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GroupManager implements GroupService {
    private final GroupRepository groupsRepository;
    @Override
    public List<Group> getAllGroups() {
        return groupsRepository.findAll();
    }

    @Override
    public Optional<Group> getGroupById(Long groupId) {
        return groupsRepository.findById(groupId);
    }

    @Override
    public Group createGroup(Group group) {
        return groupsRepository.save(group);
    }

    @Override
    public Group updateGroup(Long groupId, Group updatedGroup) {
        Optional<Group> group = groupsRepository.findById(groupId);

        if (group.isPresent()) {
            Group foundGroup = group.get();
            foundGroup.setGroupName(updatedGroup.getGroupName());
            foundGroup.setCompany(updatedGroup.getCompany());
            foundGroup.setParentGroup(updatedGroup.getParentGroup());
            return groupsRepository.save(foundGroup);
        }
        else {
            return null;
        }
    }

    @Override
    public void deleteGroup(Long groupId) {
        groupsRepository.deleteById(groupId);

    }
}
