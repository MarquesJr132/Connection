package com.example.connection.service;

import com.example.connection.controller.EmailController;
import com.example.connection.model.Account;
import com.example.connection.model.SignUp;
import com.example.connection.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountImpl implements AccountService {
    @Autowired
    AccountRepository ar;

    @Override
    public boolean saveCliente(Account cl) {
        try {
//            SignUp sn= sur.save(cl);
//            if(sn!=null){
//                return true;
//            }else{
//                return false;
//            }
            List<Account> allAccount = ar.findAll();
            if (allAccount.isEmpty()) {
                Account ac = ar.save(cl);
                EmailController ec = new EmailController();
                ec.sendMail(cl.getEmail(),"link-por-se-gerar-com-codigo",cl.getPrimeiroNome(),cl.getUltimoNome());
                return true;
            } else {
                for (Account adap : allAccount) {
                    if (!adap.getEmail().equals(cl.getEmail())) {
                        Account ac = ar.save(cl);
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
