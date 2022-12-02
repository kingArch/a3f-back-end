package com.a3f.building.entities;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository <UserEntity, String>{
    
  @Query("{ 'username' : ?0 }")
  UserEntity findByUsername(String userName);
}
