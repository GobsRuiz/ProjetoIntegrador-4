package com.fatec.projetoIntegrador4.services.servicesImplement;

import com.fatec.projetoIntegrador4.services.DashControleService;

import org.springframework.stereotype.Service;

@Service
public class DashControleImplementsService implements DashControleService{

    String varLogin = "logado";
    
    public String verificarLogin(){
        return varLogin;
    }

    public void mudarValor(String valor){
        varLogin = valor;
    }
}
