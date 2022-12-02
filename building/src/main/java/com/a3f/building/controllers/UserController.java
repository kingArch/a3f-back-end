package com.a3f.building.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.a3f.building.entities.UserEntity;
import com.a3f.building.services.interfaces.AppUserService;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    
    @Autowired
    AppUserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> get(@PathVariable final String id){
        return ResponseEntity.ok(this.userService.getUser(id));
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAll() {
        return ResponseEntity.ok(this.userService.getUsers());
    }

    @PostMapping
    public ResponseEntity<UserEntity> create(@RequestBody final UserEntity request){
        return ResponseEntity.ok(this.userService.saveUserEntity(request));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable final String id) {
        this.userService.deleteUser(id);
    }
}
