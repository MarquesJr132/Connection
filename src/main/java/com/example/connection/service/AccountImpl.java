package com.example.connection.service;

import com.example.connection.controller.EmailController;
import com.example.connection.model.Account;
import com.example.connection.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountImpl implements AccountService {


    private final AccountRepository ar;
    private final EmailController ec;

    @Autowired
    public AccountImpl(AccountRepository ar, EmailController ec) {
        this.ar = ar;
        this.ec = ec;
    }

    @Override
    public boolean saveCliente(Account cl) {
        try {
            Account ac = ar.save(cl);
            ec.sendMail(cl.getEmail(),"link",cl.getPrimeiroNome(),cl.getUltimoNome());
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
