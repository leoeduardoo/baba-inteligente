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
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false, insertable = false)
    private Long id;

    @JsonProperty("username")
    @Column(name = "username", unique = true, updatable = false)
    private String username;

    @JsonProperty("password")
    @Column(name = "password", updatable = false)
    private String password;

}