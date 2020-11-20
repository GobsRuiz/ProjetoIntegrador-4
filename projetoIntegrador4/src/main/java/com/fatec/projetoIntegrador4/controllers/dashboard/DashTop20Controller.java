package com.fatec.projetoIntegrador4.controllers.dashboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.fatec.projetoIntegrador4.models.Musica;
import com.fatec.projetoIntegrador4.models.Top20;
import com.fatec.projetoIntegrador4.services.DashControleService;
import com.fatec.projetoIntegrador4.services.MusicaService;
import com.fatec.projetoIntegrador4.services.Top20Service;

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
public class DashTop20Controller {
   
    @Autowired
    private Top20Service top20Service;
    @Autowired
    private MusicaService musicaService;
    @Autowired
    private DashControleService dashControleService;



    // Index
    @GetMapping("/dashboard/top20")
    public String index(Model model){
        List<Top20> top20s = top20Service.findAll();
        model.addAttribute("top20s", top20s);

        List<Musica> musicas = musicaService.findAll();
        model.addAttribute("musicas", musicas);
        
        String verificarLogin = dashControleService.verificarLogin();
        model.addAttribute("verificarLogin", verificarLogin);

        return "/dashboard/pages/top20/index";
    }



    // Store
    @PostMapping("/dashboard/top20/cadastrar")
    public String store(@Valid Top20 top20, BindingResult result, RedirectAttributes attributes, HttpServletRequest request){
        if(result.hasErrors()) {
            attributes.addFlashAttribute("error", "Verifique se todos os campos foram preenchidos!");

            return "redirect:/dashboard/top20";
        }else{
            attributes.addFlashAttribute("success", "Musica adicionada no top20 com sucesso!");
        }

        Long id = Long.parseLong(request.getParameter("musica_id")); 
        Musica musica = musicaService.findById(id);
        musica.setTop20("sim");
        musicaService.save(musica);
        
        top20.setMusica(musica);
        top20Service.save(top20);
        return "redirect:/dashboard/top20";
    }



    // Show
    @GetMapping("/dashboard/top20/detalhes/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        Top20 top20 = top20Service.findById(id);
        model.addAttribute("top20", top20);
        return "/dashboard/pages/top20/detalhes";
    }



    // Edit
    @GetMapping("/dashboard/top20/editar/{id}")
    public String edit(@PathVariable("id") Long id, Model model)
    {   
        Top20 top20 = top20Service.findById(id);
        model.addAttribute("top20", top20);

        List<Musica> musicas = musicaService.findAll();
        model.addAttribute("musicas", musicas);
        
        return "/dashboard/pages/top20/editar";
    }

    @RequestMapping("/dashboard/top20/update/{id}")
    public String update(@Valid Top20 top20, BindingResult result, RedirectAttributes attributes, HttpServletRequest request, Model model)
    {
        if(result.hasErrors()) {
            attributes.addFlashAttribute("error", "Verifique se todos os campos foram preenchidos!");

            return "redirect:/dashboard/top20";
        }else{
            attributes.addFlashAttribute("success", "Musica do top20 editada com sucesso!");
        }

        
        Long id = Long.parseLong(request.getParameter("musica"));
        Musica musica = musicaService.findById(id);

        top20.setMusica(musica);
        top20Service.save(top20);

        return "redirect:/dashboard/top20";
    }



    // Delete
    @RequestMapping("/dashboard/top20/deletar/{id}")
    public String destroy(@PathVariable("id") Long id, RedirectAttributes attributes){

        
        try {
            Top20 top20 = top20Service.findById(id);
            Musica musica = musicaService.findById(top20.getMusica().getId());
            musica.setTop20("nao");
            musicaService.save(musica);
            top20Service.delete(id);
            attributes.addFlashAttribute("success", "Verifique se todos os campos foram preenchidos!");
        } catch (Exception e) {
            attributes.addFlashAttribute("error", "Verifique se todos os campos foram preenchidos!");
            return "redirect:/dashboard/top20";
        }
        
        
        return "redirect:/dashboard/top20";
    }
}
