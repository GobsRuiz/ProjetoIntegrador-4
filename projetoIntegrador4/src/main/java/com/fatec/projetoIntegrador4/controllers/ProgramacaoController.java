package com.fatec.projetoIntegrador4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProgramacaoController {
    
    @GetMapping("/programacao")
    public String programacao() 
    {
        return "pages/programacao/programacao";
    }
}
