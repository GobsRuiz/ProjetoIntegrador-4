package com.fatec.projetoIntegrador4.controllers;

import javax.validation.Valid;

import com.fatec.projetoIntegrador4.models.PedirMusica;
import com.fatec.projetoIntegrador4.services.PedirMusicaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PedirMusicaController {
    
    // Service
    @Autowired
    private PedirMusicaService pedirMusicaService;



    // Store
    @PostMapping("/pedir-musica/cadastrar")
    public String store(@Valid PedirMusica pedirMusica, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("error", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/";
        }else{
            attributes.addFlashAttribute("success", "Enviado com sucesso!");
        }

        pedirMusicaService.save(pedirMusica);
        return "redirect:/";
    }
}
