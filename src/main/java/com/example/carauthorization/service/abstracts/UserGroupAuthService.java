package com.example.carauthorization.service.abstracts;


import com.example.carauthorization.model.UserGroupAuthorization;

import java.util.List;
import java.util.Optional;

public interface UserGroupAuthService {
    public List<UserGroupAuthorization> getAllUserGroupAuth();
    public Optional<UserGroupAuthorization> getUserGroupAuthById(Long userGroupAuthId);
    public UserGroupAuthorization createUserGroupAuth(UserGroupAuthorization userGroupAuthorization);
    public UserGroupAuthorization updateUserGroupAuth(Long userGroupAuthId, UserGroupAuthorization updatedUserGroupAuthorization);
    public void deleteUserGroupAuth(Long userGroupAuthId);
}
