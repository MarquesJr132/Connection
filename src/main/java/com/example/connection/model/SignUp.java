package com.example.connection.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SignUp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String nome;


    private int idade;

    private String password;
}
