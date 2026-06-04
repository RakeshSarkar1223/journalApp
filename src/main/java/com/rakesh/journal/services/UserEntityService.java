package com.rakesh.journal.services;

import com.rakesh.journal.entity.UserEntity;
import com.rakesh.journal.repository.UserEntityRepository;
import lombok.Data;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserEntityService {
    private UserEntityRepository userEntityRepository;
    public UserEntityService(UserEntityRepository userEntityRepository){
        this.userEntityRepository = userEntityRepository;
    }

    public UserEntity createUser(UserEntity userEntity) {
        return userEntityRepository.save(userEntity);
    }

    public List<UserEntity> getAllUser() {
        return userEntityRepository.findAll();
    }

    public Optional<UserEntity> getById(String id) {
        return userEntityRepository.findById(id);
    }
}
