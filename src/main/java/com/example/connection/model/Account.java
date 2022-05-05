package com.example.connection.model;

import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "conta")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotEmpty
    private String primeiroNome;

    @NotNull
    @NotEmpty
    private String ultimoNome;

    @NotNull
    @NotEmpty
    private String password;

    @Email(message = "email invalido")
    @NotEmpty
    @Column(unique = true)
    private String email;

}
