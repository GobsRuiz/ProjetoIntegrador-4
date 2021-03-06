package com.fatec.projetoIntegrador4.controllers;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Noticia;
import com.fatec.projetoIntegrador4.services.NoticiaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    // Service
    @Autowired
    private NoticiaService noticiaService;



    // Index
    @GetMapping("/")
    public String index(Model model) 
    {
        List<Noticia> noticias = noticiaService.findAll();
        model.addAttribute("noticias", noticias);

        return "pages/index/index";
    }
}
