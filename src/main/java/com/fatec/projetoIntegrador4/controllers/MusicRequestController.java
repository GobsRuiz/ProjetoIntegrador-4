package com.fatec.projetoIntegrador4.controllers;

import java.util.List;

import javax.validation.Valid;

import com.fatec.projetoIntegrador4.models.MusicRequest;
import com.fatec.projetoIntegrador4.services.MusicRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MusicRequestController {
    
    // Service
    @Autowired
    private MusicRequestService musicService;



    // Index
    @GetMapping("/teste/pedidos-de-musicas")
    public ModelAndView index()
    {
        ModelAndView mv = new ModelAndView("test/musicRequest/index");
        List<MusicRequest> musicRequests = musicService.findAll();
        mv.addObject("musicRequests", musicRequests);
        return mv;
    }



    // Store
    @PostMapping("/teste/pedidos-de-musicas/cadastrar")
    public String store(@Valid MusicRequest musicRequest, BindingResult result, RedirectAttributes attributes)
    {
        if(result.hasErrors()){
            attributes.addFlashAttribute("error", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/teste/pedidos-de-musicas";
        }

        musicService.save(musicRequest);
        return "redirect:/teste/pedidos-de-musicas";
    }



    // delete
    @RequestMapping("/teste/pedidos-de-musica/deletar/{id}")
    public String destroy(@PathVariable("id") Long id)
    {
        musicService.delete(id);
        return "redirect:/teste/pedidos-de-musicas";
    }
}
