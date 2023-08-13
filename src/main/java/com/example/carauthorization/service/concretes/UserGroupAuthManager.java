package com.example.carauthorization.service.concretes;

import com.example.carauthorization.model.Group;
import com.example.carauthorization.model.UserGroupAuthorization;
import com.example.carauthorization.repository.UserGroupAuthRepo;
import com.example.carauthorization.service.abstracts.UserGroupAuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserGroupAuthManager implements UserGroupAuthService {
    private final UserGroupAuthRepo userGroupAuthRepo;
    @Override
    public List<UserGroupAuthorization> getAllUserGroupAuth() {
        return userGroupAuthRepo.findAll();
    }

    @Override
    public Optional<UserGroupAuthorization> getUserGroupAuthById(Long userGroupAuthId) {
        return userGroupAuthRepo.findById(userGroupAuthId);
    }

    @Override
    public UserGroupAuthorization createUserGroupAuth(UserGroupAuthorization userGroupAuthorization) {
        return userGroupAuthRepo.save(userGroupAuthorization);
    }

    @Override
    public UserGroupAuthorization updateUserGroupAuth(Long userGroupAuthId, UserGroupAuthorization updatedUserGroupAuthorization) {
        Optional<UserGroupAuthorization> userGroupAuthorization= userGroupAuthRepo.findById(userGroupAuthId);

        if (userGroupAuthorization.isPresent()) {
            UserGroupAuthorization foundUserGroupAuth = userGroupAuthorization.get();
            foundUserGroupAuth.setGroup(updatedUserGroupAuthorization.getGroup());
            foundUserGroupAuth.setUser(updatedUserGroupAuthorization.getUser());
            foundUserGroupAuth.setAuthorization_id(updatedUserGroupAuthorization.getAuthorization_id());
            return userGroupAuthRepo.save(foundUserGroupAuth);
        }
        else {
            return null;
        }
    }

    @Override
    public void deleteUserGroupAuth(Long userGroupAuthId) {
        userGroupAuthRepo.deleteById(userGroupAuthId);

    }
}
