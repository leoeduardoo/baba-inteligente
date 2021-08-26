package com.grupo03.kafka.util.mapper;

import com.grupo03.kafka.model.Allergy;
import com.grupo03.kafka.model.Baby;
import com.grupo03.kafka.model.DTO.BabyDTO;
import com.grupo03.kafka.model.Request.AllergyRequest;
import com.grupo03.kafka.model.Request.BabyRequest;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2021-08-26T00:10:35-0300",
        comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_261 (Oracle Corporation)"
)
public class BabyMapperImpl implements BabyMapper {

    @Override
    public Baby babyDTOToBaby(BabyDTO babyDTO) {
        if (babyDTO == null) {
            return null;
        }

        Baby baby = new Baby();

        baby.setId(babyDTO.getId());
        baby.setName(babyDTO.getName());
        baby.setAge(babyDTO.getAge());
        baby.setGender(babyDTO.getGender());
        baby.setBirthDate(babyDTO.getBirthDate());
        List<Allergy> list = babyDTO.getAllergies();
        if (list != null) {
            baby.setAllergies(new ArrayList<Allergy>(list));
        }

        return baby;
    }

    @Override
    public BabyDTO babyToBabyDTO(Baby baby) {
        if (baby == null) {
            return null;
        }

        BabyDTO babyDTO = new BabyDTO();

        babyDTO.setId(baby.getId());
        babyDTO.setName(baby.getName());
        babyDTO.setAge(baby.getAge());
        babyDTO.setGender(baby.getGender());
        babyDTO.setBirthDate(baby.getBirthDate());
        List<Allergy> list = baby.getAllergies();
        if (list != null) {
            babyDTO.setAllergies(new ArrayList<Allergy>(list));
        }

        return babyDTO;
    }

    @Override
    public BabyDTO babyRequestToBabyDTO(BabyRequest babyRequest) {
        if (babyRequest == null) {
            return null;
        }

        BabyDTO babyDTO = new BabyDTO();

        babyDTO.setName(babyRequest.getName());
        babyDTO.setAge(babyRequest.getAge());
        babyDTO.setGender(babyRequest.getGender());
        babyDTO.setBirthDate(babyRequest.getBirthDate());
        babyDTO.setAllergies(allergyRequestListToAllergyList(babyRequest.getAllergies()));

        return babyDTO;
    }

    protected Allergy allergyRequestToAllergy(AllergyRequest allergyRequest) {
        if (allergyRequest == null) {
            return null;
        }

        Allergy allergy = new Allergy();

        allergy.setType(allergyRequest.getType());
        allergy.setDescription(allergyRequest.getDescription());

        return allergy;
    }

    protected List<Allergy> allergyRequestListToAllergyList(List<AllergyRequest> list) {
        if (list == null) {
            return null;
        }

        List<Allergy> list1 = new ArrayList<Allergy>(list.size());
        for (AllergyRequest allergyRequest : list) {
            list1.add(allergyRequestToAllergy(allergyRequest));
        }

        return list1;
    }
}
