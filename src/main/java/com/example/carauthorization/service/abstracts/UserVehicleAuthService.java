package com.example.carauthorization.service.abstracts;

import com.example.carauthorization.model.UserGroupAuthorization;
import com.example.carauthorization.model.UserVehicleAuthorization;

import java.util.List;
import java.util.Optional;

public interface UserVehicleAuthService {
    public List<UserVehicleAuthorization> getAllUserVehicleAuth();
    public Optional<UserVehicleAuthorization> getUserVehicleAuthById(Long userVehicleAuthId);
    public UserVehicleAuthorization createUserVehicleAuth(UserVehicleAuthorization userVehicleAuthorization);
    public UserVehicleAuthorization updateUserVehicleAuth(Long userVehicleAuthId, UserVehicleAuthorization updatedUserVehicleAuthorization);
    public void deleteUserVehicleAuth(Long userVehicleAuthId);
}
