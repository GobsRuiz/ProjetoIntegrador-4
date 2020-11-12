package com.fatec.projetoIntegrador4.controllers;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Equipe;
import com.fatec.projetoIntegrador4.services.EquipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EquipeController {
    
    // Service
    @Autowired
    private EquipeService equipeService;



    // Index
    @GetMapping("/equipe")
    public String equipe(Model model) 
    {
        List<Equipe> equipes = equipeService.findAll();
        model.addAttribute("equipes", equipes);

        return "pages/equipe/equipe";
    }
}
