package com.grupo03.kafka.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Allergy")
public class Allergy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false, insertable = false)
    private Long id;

    @JsonProperty("type")
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private AllergyType type;

    @JsonProperty("description")
    @Column(name = "description")
    private String description;

}