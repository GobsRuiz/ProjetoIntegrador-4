package com.fatec.projetoIntegrador4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Top20Controller {
    
    @GetMapping("/top20")
    public String top20() 
    {
        return "pages/top20/top20";
    }
}
