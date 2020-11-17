package com.fatec.projetoIntegrador4.controllers.dashboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.fatec.projetoIntegrador4.models.Artista;
import com.fatec.projetoIntegrador4.models.Musica;
import com.fatec.projetoIntegrador4.services.ArtistaService;
import com.fatec.projetoIntegrador4.services.DashControleService;
import com.fatec.projetoIntegrador4.services.MusicaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DashArtistaController {
    
    @Autowired
    private ArtistaService artistaService;
    @Autowired
    private MusicaService musicaService;
    @Autowired
    private DashControleService dashControleService;


    // Index
    @GetMapping("/dashboard/artistas")
    public String index(Model model){
        List<Artista> artistas = artistaService.findAll();
        model.addAttribute("artistas", artistas);

        List<Musica> musicas = musicaService.findAll();
        model.addAttribute("musicas", musicas);
        
        String verificarLogin = dashControleService.verificarLogin();
        model.addAttribute("verificarLogin", verificarLogin);

        return "/dashboard/pages/artistas/index";
    }



    // Store
    @PostMapping("/dashboard/artistas/cadastrar")
    public String store(@Valid Artista artista, BindingResult result, RedirectAttributes attributes, HttpServletRequest request){
        if(result.hasErrors()) {
            attributes.addFlashAttribute("error", "Verifique se todos os campos foram preenchidos!");

            return "redirect:/dashboard/autores";
        }else{
            attributes.addFlashAttribute("success", "Artista adicionado com sucesso!");
        }

        artistaService.save(artista);
        return "redirect:/dashboard/artistas";
    }



    // Show
    @GetMapping("/dashboard/artistas/detalhes/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        Artista artista = artistaService.findById(id);
        model.addAttribute("artista", artista);
        return "/dashboard/pages/artistas/detalhes";
    }



    // Edit
    @GetMapping("/dashboard/artistas/editar/{id}")
    public String edit(@PathVariable("id") Long id, Model model)
    {   
        Artista artista = artistaService.findById(id);
        model.addAttribute("artista", artista);
        
        return "/dashboard/pages/artistas/editar";
    }

    @RequestMapping("/dashboard/artistas/update/{id}")
    public String update(@Valid Artista artista, BindingResult result, RedirectAttributes attributes, Model model)
    {
        if(result.hasErrors()) {
            attributes.addFlashAttribute("error", "Verifique se todos os campos foram preenchidos!");

            return "redirect:/dashboard/autores";
        }else{
            attributes.addFlashAttribute("success", "Artista editado com sucesso!");
        }

        artistaService.save(artista);
        return "redirect:/dashboard/artistas";
    }



    // Delete
    @RequestMapping("/dashboard/artistas/deletar/{id}")
    public String destroy(@PathVariable("id") Long id, RedirectAttributes attributes){
        attributes.addFlashAttribute("success", "Artista deletado com sucesso!");

        artistaService.delete(id);
        return "redirect:/dashboard/artistas";
    }
}
