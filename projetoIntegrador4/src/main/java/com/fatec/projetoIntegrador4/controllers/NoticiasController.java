package com.fatec.projetoIntegrador4.controllers;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Noticia;
import com.fatec.projetoIntegrador4.services.NoticiaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NoticiasController {
    
    // Service
    @Autowired
    private NoticiaService noticiaService;



    // Index
    @GetMapping("/noticias")
    public String noticias(Model model) 
    {
        List<Noticia> noticias = noticiaService.findAll();
        model.addAttribute("noticias", noticias);

        return "pages/noticias/noticias";
    }




    // Show
    @GetMapping("/noticias/{titulo}/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        Noticia noticia = noticiaService.findById(id);
        model.addAttribute("noticia", noticia);
        return "/pages/noticias/detalhes";
    }
}
