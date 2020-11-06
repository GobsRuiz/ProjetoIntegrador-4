package com.fatec.projetoIntegrador4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoticiasController {
    
    @GetMapping("/noticias")
    public String noticias() 
    {
        return "pages/noticias/noticias";
    }
}
