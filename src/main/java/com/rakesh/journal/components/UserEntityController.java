package com.rakesh.journal.components;

import com.rakesh.journal.entity.UserEntity;
import com.rakesh.journal.services.UserEntityService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserEntityController {

    private final UserEntityService userEntityService;

    // Constructor Injection (Best Practice ✅)
    public UserEntityController(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    // ✅ Get all users
    @GetMapping
    public ResponseEntity<List<UserEntity>> getAll() {
        List<UserEntity> users = userEntityService.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // ✅ Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getById(@PathVariable String id) {
        Optional<UserEntity> user = userEntityService.getById(id);

        if(user.isPresent()){
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ✅ Create new user
    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody @Valid UserEntity userEntity) {
        try {
            UserEntity savedUser = userEntityService.createUser(userEntity);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}