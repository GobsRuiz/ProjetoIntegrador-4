package com.fatec.projetoIntegrador4.controllers.dashboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.fatec.projetoIntegrador4.models.Artista;
import com.fatec.projetoIntegrador4.models.Musica;
import com.fatec.projetoIntegrador4.services.ArtistaService;
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
public class DashMusicaController {
    
    @Autowired
    private MusicaService musicaService;
    @Autowired
    private ArtistaService artistaService;



    // Index
    @GetMapping("/dashboard/musicas")
    public String index(Model model){
        List<Musica> musicas = musicaService.findAll();
        model.addAttribute("musicas", musicas);

        List<Artista> artistas = artistaService.findAll();
        model.addAttribute("artistas", artistas);

        return "/dashboard/pages/musicas/index";
    }



    // Store
    @PostMapping("/dashboard/musicas/cadastrar")
    public String store(@Valid Musica musica, BindingResult result, RedirectAttributes attributes, HttpServletRequest request){
        if(result.hasErrors()) {
            attributes.addFlashAttribute("error", "Verifique se todos os campos foram preenchidos!");

            return "redirect:/dashboard/musicas";
        }else{
            attributes.addFlashAttribute("success", "Musica adicionada com sucesso!");
        }

        Long id = Long.parseLong(request.getParameter("artista_id")); 
        Artista artista = artistaService.findById(id);
        
        // autor.setName(artista.getName());
        musica.setArtista(artista);
        musicaService.save(musica);
        return "redirect:/dashboard/musicas";
    }



    // Show
    @GetMapping("/dashboard/musicas/detalhes/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        Musica musica = musicaService.findById(id);
        model.addAttribute("musica", musica);
        return "/dashboard/pages/musicas/detalhes";
    }



    // Edit
    @GetMapping("/dashboard/musicas/editar/{id}")
    public String edit(@PathVariable("id") Long id, Model model)
    {   
        Musica musica = musicaService.findById(id);
        model.addAttribute("musica", musica);

        List<Artista> artistas = artistaService.findAll();
        model.addAttribute("artistas", artistas);
        
        return "/dashboard/pages/musicas/editar";
    }

    @RequestMapping("/dashboard/musicas/update/{id}")
    public String update(@Valid Musica musica, BindingResult result, RedirectAttributes attributes, HttpServletRequest request, Model model)
    {
        if(result.hasErrors()) {
            attributes.addFlashAttribute("error", "Verifique se todos os campos foram preenchidos!");

            return "redirect:/dashboard/musicas";
        }else{
            attributes.addFlashAttribute("success", "Musica editada com sucesso!");
        }

        Long id = Long.parseLong(request.getParameter("artista_id")); 
        Artista artista = artistaService.findById(id);
        
        // autor.setName(artista.getName());
        musica.setArtista(artista);
        musicaService.save(musica);

        return "redirect:/dashboard/musicas";
    }



    // Delete
    @RequestMapping("/dashboard/musicas/deletar/{id}")
    public String destroy(@PathVariable("id") Long id, RedirectAttributes attributes){
        attributes.addFlashAttribute("success", "Musica deletado com sucesso!");

        musicaService.delete(id);
        return "redirect:/dashboard/musicas";
    }
}
