package com.grupo03.kafka.model.DTO;

import com.grupo03.kafka.model.Allergy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BabyDTO {

    private Long id;
    private String name;
    private Integer age;
    private String gender;
    private String birthDate;
    private List<Allergy> allergies;

}