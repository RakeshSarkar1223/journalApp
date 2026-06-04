package com.rakesh.journal.repository;

import com.rakesh.journal.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserEntityRepository extends MongoRepository<UserEntity, String> {
    UserEntity findByUsername(String username);
}
