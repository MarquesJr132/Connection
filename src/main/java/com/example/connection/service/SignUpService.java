package com.example.connection.service;

import com.example.connection.model.SignUp;

import java.util.List;

public interface SignUpService {
    boolean saveCliente(SignUp cl);
    List<SignUp> listaClientes();
}
