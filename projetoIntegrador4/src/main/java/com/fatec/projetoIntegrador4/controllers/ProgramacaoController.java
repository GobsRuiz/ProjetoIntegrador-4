package com.fatec.projetoIntegrador4.controllers;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Equipe;
import com.fatec.projetoIntegrador4.models.Programacao;
import com.fatec.projetoIntegrador4.services.EquipeService;
import com.fatec.projetoIntegrador4.services.ProgramacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProgramacaoController {
    
    // Service
    @Autowired
    private ProgramacaoService programacaoService;
    @Autowired
    private EquipeService equipeService;
    


    // Index
    @GetMapping("/programacao")
    public String programacao(Model model) 
    {
        List<Programacao> programas = programacaoService.findAll();
        model.addAttribute("programas", programas);

        List<Equipe> equipes = equipeService.findAll();
        model.addAttribute("equipes", equipes);

        return "pages/programacao/programacao";
    }
}
