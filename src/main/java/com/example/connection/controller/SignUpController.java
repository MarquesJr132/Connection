package com.example.connection.controller;

import com.example.connection.model.SignUp;
import com.example.connection.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/signUp")
public class SignUpController {
    @Autowired
    SignUpService sus;
    //asdasd

    @PostMapping(path = "/save")
    public ResponseEntity<?> saveCliente(@RequestBody SignUp su){
        if(sus.saveCliente(su)){
            return new ResponseEntity<>("Cliente salvado com sucesso",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Nao salvado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/lista")
    public List<SignUp> findAll(){
        return sus.listaClientes();
    }
}
