package com.grupo03.kafka.service;

import com.grupo03.kafka.exception.NotFoundException;
import com.grupo03.kafka.model.Baby;
import com.grupo03.kafka.model.DTO.BabyDTO;
import com.grupo03.kafka.model.MyUser;
import com.grupo03.kafka.repository.BabyRepository;
import com.grupo03.kafka.util.mapper.BabyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BabyService {

    @Autowired
    BabyRepository babyRepository;

    @Autowired
    UserService userService;

    public BabyDTO get(String username) throws NotFoundException {

        MyUser myUser = userService.loadMyUserByUsername(username);

        if (myUser == null) {
            throw new NotFoundException(username);
        }

        return BabyMapper.INSTANCE.babyToBabyDTO(babyRepository.findFirstByParentId(myUser.getId()).orElseThrow(() -> new NotFoundException(username + "'s baby")));
    }

    public BabyDTO save(BabyDTO babyDTO, String username) throws NotFoundException {

        MyUser myUser = userService.loadMyUserByUsername(username);

        if (myUser == null) {
            throw new NotFoundException(username);
        }

        findBabyAndSetParameters(babyDTO, myUser);

        return BabyMapper.INSTANCE.babyToBabyDTO(babyRepository.save(BabyMapper.INSTANCE.babyDTOToBaby(babyDTO)));
    }

    private void findBabyAndSetParameters(BabyDTO babyDTO, MyUser myUser) {
        Optional<Baby> babyOptional = babyRepository.findFirstByParentId(myUser.getId());

        if (babyOptional.isPresent()) {
            babyDTO.setId(babyDTO.getId());
            verifyAllergies(babyDTO, babyOptional.get());
        }

        babyDTO.setParentId(myUser.getId());
    }

    private void verifyAllergies(BabyDTO babyDTO, Baby baby) {
        babyDTO.setId(baby.getId());
        for (int i = 0; i < babyDTO.getAllergies().size(); i++) {
            for (int j = 0; j < baby.getAllergies().size(); j++) {
                if (babyDTO.getAllergies().get(i).getDescription().equals(baby.getAllergies().get(j).getDescription())
                        && babyDTO.getAllergies().get(i).getType().equals(baby.getAllergies().get(j).getType())) {
                    babyDTO.getAllergies().get(i).setId(baby.getAllergies().get(j).getId());
                    baby.getAllergies().remove(j);
                }
            }
        }
        babyDTO.getAllergies().addAll(baby.getAllergies());
    }

}