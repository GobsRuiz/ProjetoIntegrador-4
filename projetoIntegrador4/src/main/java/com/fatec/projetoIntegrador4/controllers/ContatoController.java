package com.fatec.projetoIntegrador4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContatoController {
    
    @GetMapping("/contato")
    public String contato() 
    {
        return "pages/contato/contato";
    }
}
