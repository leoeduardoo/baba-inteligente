package com.grupo03.kafka.util.mapper;

import com.grupo03.kafka.model.Baby;
import com.grupo03.kafka.model.DTO.BabyDTO;
import com.grupo03.kafka.model.Request.BabyRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BabyMapper {

    BabyMapper INSTANCE = Mappers.getMapper(BabyMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "parentId", source = "parentId"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "age", source = "age"),
            @Mapping(target = "gender", source = "gender"),
            @Mapping(target = "birthDate", source = "birthDate"),
            @Mapping(target = "allergies", source = "allergies")
    })
    Baby babyDTOToBaby(BabyDTO babyDTO);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "parentId", source = "parentId"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "age", source = "age"),
            @Mapping(target = "gender", source = "gender"),
            @Mapping(target = "birthDate", source = "birthDate"),
            @Mapping(target = "allergies", source = "allergies")
    })
    BabyDTO babyToBabyDTO(Baby baby);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "parentId", ignore = true),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "age", source = "age"),
            @Mapping(target = "gender", source = "gender"),
            @Mapping(target = "birthDate", source = "birthDate"),
            @Mapping(target = "allergies", source = "allergies")
    })
    BabyDTO babyRequestToBabyDTO(BabyRequest babyRequest);

}
