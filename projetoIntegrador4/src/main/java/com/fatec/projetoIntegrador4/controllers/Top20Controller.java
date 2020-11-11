package com.fatec.projetoIntegrador4.controllers;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Musica;
import com.fatec.projetoIntegrador4.models.Top20;
import com.fatec.projetoIntegrador4.services.MusicaService;
import com.fatec.projetoIntegrador4.services.Top20Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Top20Controller {
    
    // Service
    @Autowired
    private Top20Service top20Service;
    @Autowired
    private MusicaService musicaService;



    // Index
    @GetMapping("/top20")
    public String top20(Model model) 
    {
        List<Top20> top20s = top20Service.findAll();
        model.addAttribute("top20s", top20s);

        List<Musica> musicas = musicaService.findAll();
        model.addAttribute("musicas", musicas);

        return "pages/top20/top20";
    }
}
