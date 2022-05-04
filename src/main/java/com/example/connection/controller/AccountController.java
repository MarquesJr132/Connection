package com.example.connection.controller;

import com.example.connection.model.Account;
import com.example.connection.service.AccountService;
import com.example.connection.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/account")
public class AccountController {
    @Autowired
    AccountService sus;
    //My main app
    @PostMapping(path = "/saveaccount")
    public ResponseEntity<?> saveAccount(@RequestBody Account cac){
        if(sus.saveCliente(cac)){
            return new ResponseEntity<>("Cliente salvado com sucesso", HttpStatus.OK);
        }else {
            return new ResponseEntity<>(cac.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
