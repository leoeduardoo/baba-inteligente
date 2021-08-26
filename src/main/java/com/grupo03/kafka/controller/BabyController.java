package com.grupo03.kafka.controller;

import com.grupo03.kafka.exception.NotFoundException;
import com.grupo03.kafka.model.DTO.BabyDTO;
import com.grupo03.kafka.model.Request.BabyRequest;
import com.grupo03.kafka.service.BabyService;
import com.grupo03.kafka.util.mapper.BabyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BabyController {

    @Autowired
    private BabyService babyService;

    @PostMapping("baby")
    public ResponseEntity<BabyDTO> save(@RequestBody BabyRequest babyRequest, @RequestParam("username") String username) throws NotFoundException {
        return new ResponseEntity(babyService.save(BabyMapper.INSTANCE.babyRequestToBabyDTO(babyRequest), username), HttpStatus.OK);
    }

}