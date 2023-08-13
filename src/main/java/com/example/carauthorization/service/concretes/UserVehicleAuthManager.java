package com.example.carauthorization.service.concretes;

import com.example.carauthorization.model.UserGroupAuthorization;
import com.example.carauthorization.model.UserVehicleAuthorization;
import com.example.carauthorization.repository.UserVehicleAuthRepo;
import com.example.carauthorization.service.abstracts.UserVehicleAuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserVehicleAuthManager implements UserVehicleAuthService {
    private final UserVehicleAuthRepo userVehicleAuthRepo;
    @Override
    public List<UserVehicleAuthorization> getAllUserVehicleAuth() {
        return userVehicleAuthRepo.findAll();
    }

    @Override
    public Optional<UserVehicleAuthorization> getUserVehicleAuthById(Long userVehicleAuthId) {
        return userVehicleAuthRepo.findById(userVehicleAuthId);
    }

    @Override
    public UserVehicleAuthorization createUserVehicleAuth(UserVehicleAuthorization userVehicleAuthorization) {
        return userVehicleAuthRepo.save(userVehicleAuthorization);
    }

    @Override
    public UserVehicleAuthorization updateUserVehicleAuth(Long userVehicleAuthId, UserVehicleAuthorization updatedUserVehicleAuthorization) {
        Optional<UserVehicleAuthorization> userVehicleAuthorization= userVehicleAuthRepo.findById(userVehicleAuthId);

        if (userVehicleAuthorization.isPresent()) {
            UserVehicleAuthorization foundUserVehicleAuth = userVehicleAuthorization.get();
            foundUserVehicleAuth.setVehicle(updatedUserVehicleAuthorization.getVehicle());
            foundUserVehicleAuth.setUser(updatedUserVehicleAuthorization.getUser());
            foundUserVehicleAuth.setAuthorization_id(updatedUserVehicleAuthorization.getAuthorization_id());

            return userVehicleAuthRepo.save(foundUserVehicleAuth);
        }
        else {
            return null;
        }
    }

    @Override
    public void deleteUserVehicleAuth(Long userVehicleAuthId) {
        userVehicleAuthRepo.deleteById(userVehicleAuthId);
    }
}
