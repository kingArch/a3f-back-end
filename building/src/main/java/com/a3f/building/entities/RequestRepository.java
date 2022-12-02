package com.a3f.building.entities;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RequestRepository extends MongoRepository<RequestEntity,String> {}
