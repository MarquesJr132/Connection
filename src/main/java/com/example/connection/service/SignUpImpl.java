package com.example.connection.service;

import com.example.connection.model.SignUp;
import com.example.connection.repository.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class SignUpImpl implements SignUpService{
    @Autowired
    SignUpRepository sur;


    @Override
    public boolean saveCliente(SignUp cl) {
        try{
            SignUp sn= sur.save(cl);
            if(sn!=null){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<SignUp> listaClientes() {
        return sur.findAll();
    }
}
