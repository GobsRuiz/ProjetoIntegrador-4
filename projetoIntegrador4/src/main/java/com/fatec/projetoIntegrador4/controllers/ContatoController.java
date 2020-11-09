package com.fatec.projetoIntegrador4.controllers;

import javax.validation.Valid;

import com.fatec.projetoIntegrador4.models.Contato;
import com.fatec.projetoIntegrador4.services.servicesImplement.ContatoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContatoController {

    // Service
    @Autowired
    private ContatoService contato_service;
    


    // Index
    @GetMapping("/contato")
    public String contato() 
    {
        return "pages/contato/contato";
    }



    // Store
    @PostMapping("/contato/cadastrar")
    public String store(@Valid Contato contato, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("error", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/contato";
        }else{
            attributes.addFlashAttribute("success", "Enviado com sucesso!");
        }

        contato_service.save(contato);
        return "redirect:/contato";
    }
}
