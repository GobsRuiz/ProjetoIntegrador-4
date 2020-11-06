package com.fatec.projetoIntegrador4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EquipeController {
    
    @GetMapping("/equipe")
    public String equipe() 
    {
        return "pages/equipe/equipe";
    }
}
