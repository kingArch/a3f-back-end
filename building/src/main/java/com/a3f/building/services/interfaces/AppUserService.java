package com.a3f.building.services.interfaces;

import java.util.List;

import com.a3f.building.entities.UserEntity;

public interface AppUserService {
    UserEntity saveUserEntity(UserEntity user);
    UserEntity getUser(String id);
    List<UserEntity> getUsers();
    void deleteUser(String id);
}
