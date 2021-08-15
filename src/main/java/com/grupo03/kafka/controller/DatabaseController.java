package com.grupo03.kafka.controller;

import com.grupo03.kafka.model.User;
import com.grupo03.kafka.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseController {

    @Autowired
    private DatabaseService databaseService;

    @PostMapping("user")
    public ResponseEntity<User> user(@RequestBody User user) {
        return new ResponseEntity(databaseService.saveUser(user), HttpStatus.OK);
    }

}