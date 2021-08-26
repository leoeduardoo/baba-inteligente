package com.grupo03.kafka.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Baby",
        uniqueConstraints = @UniqueConstraint(columnNames = {"id", "name", "birth_date"}))
public class Baby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false, insertable = false)
    private Long id;

    @JsonProperty("name")
    @Column(name = "name")
    private String name;

    @JsonProperty("age")
    @Column(name = "age")
    private Integer age;

    @JsonProperty("gender")
    @Column(name = "gender")
    private String gender;

    @JsonProperty("birthDate")
    @Column(name = "birth_date")
    private String birthDate;

    @JsonProperty("allergies")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @ElementCollection
    private List<Allergy> allergies;

}