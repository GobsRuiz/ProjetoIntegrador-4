package com.fatec.projetoIntegrador4.controllers.dashboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.fatec.projetoIntegrador4.models.Autor;
import com.fatec.projetoIntegrador4.models.Equipe;
import com.fatec.projetoIntegrador4.services.AutorService;
import com.fatec.projetoIntegrador4.services.EquipeService;

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
public class DashAutorController {
    
    @Autowired
    private AutorService autorService;
    @Autowired
    private EquipeService equipeService;



    // Index
    @GetMapping("/dashboard/autores")
    public String index(Model model){
        List<Autor> autores = autorService.findAll();
        model.addAttribute("autores", autores);

        List<Equipe> equipes = equipeService.findAll();
        model.addAttribute("equipes", equipes);

        return "/dashboard/pages/autores/index";
    }



    // Store
    @PostMapping("/dashboard/autores/cadastrar")
    public String store(@Valid Autor autor, BindingResult result, RedirectAttributes attributes, HttpServletRequest request){
        if(result.hasErrors()) {
            attributes.addFlashAttribute("error", "Verifique se todos os campos foram preenchidos!");

            return "redirect:/dashboard/autores";
        }else{
            attributes.addFlashAttribute("success", "Autor adicionado com sucesso!");
        }

        Long id = Long.parseLong(request.getParameter("equipe_id")); 
        Equipe equipe = equipeService.findById(id);
        
        autor.setName(equipe.getName());
        autor.setEquipe(equipe);
        autorService.save(autor);
        return "redirect:/dashboard/autores";
    }



    // Show
    @GetMapping("/dashboard/autores/detalhes/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        Autor autor = autorService.findById(id);
        model.addAttribute("autor", autor);
        return "/dashboard/pages/autores/detalhes";
    }



    // Edit
    @GetMapping("/dashboard/autores/editar/{id}")
    public String edit(@PathVariable("id") Long id, Model model)
    {   
        Autor autor = autorService.findById(id);
        model.addAttribute("autor", autor);

        List<Equipe> equipes = equipeService.findAll();
        model.addAttribute("equipes", equipes);
        
        return "/dashboard/pages/autores/editar";
    }

    @RequestMapping("/dashboard/autores/update/{id}")
    public String update(@Valid Autor autor, BindingResult result, RedirectAttributes attributes, Model model)
    {
        if(result.hasErrors()) {
            attributes.addFlashAttribute("error", "Verifique se todos os campos foram preenchidos!");

            return "redirect:/dashboard/autores";
        }else{
            attributes.addFlashAttribute("success", "Autor editado com sucesso!");
        }

        return "redirect:/dashboard/autores";
    }



    // Delete
    @RequestMapping("/dashboard/autores/deletar/{id}")
    public String destroy(@PathVariable("id") Long id, RedirectAttributes attributes){
        attributes.addFlashAttribute("success", "Autor deletado com sucesso!");

        autorService.delete(id);
        return "redirect:/dashboard/autores";
    }
}
