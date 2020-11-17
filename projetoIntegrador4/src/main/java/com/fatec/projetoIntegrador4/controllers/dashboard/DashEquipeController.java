package com.fatec.projetoIntegrador4.controllers.dashboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.fatec.projetoIntegrador4.models.Autor;
import com.fatec.projetoIntegrador4.models.Equipe;
import com.fatec.projetoIntegrador4.services.AutorService;
import com.fatec.projetoIntegrador4.services.DashControleService;
import com.fatec.projetoIntegrador4.services.EquipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DashEquipeController {

    // Service
    @Autowired
    private EquipeService equipeService;
    @Autowired
    private AutorService autorService;
    @Autowired
    private DashControleService dashControleService;
    


    // Index
    @GetMapping("/dashboard/equipe")
    public String index(Model model){
        List<Equipe> equipes = equipeService.findAll();
        model.addAttribute("equipes", equipes);

        String verificarLogin = dashControleService.verificarLogin();
        model.addAttribute("verificarLogin", verificarLogin);

        return "//dashboard/pages/equipe/index";
    }



    // Store
    @PostMapping("/dashboard/equipe/cadastrar")
    public String store(Equipe equipe, HttpServletRequest request, BindingResult result, RedirectAttributes attributes, @RequestParam("imageFile") MultipartFile imageFile) {
        if(result.hasErrors()) {
            attributes.addFlashAttribute("error", "Verifique se todos os campos foram preenchidos!");

            return "redirect:/dashboard/equipe";
        }else{
            attributes.addFlashAttribute("success", "Membro da equipe adicionado com sucesso!");
        }

        String nomeOriginal = imageFile.getOriginalFilename();
        String path = "/img/" + nomeOriginal;
        String returnValue = "start";

        // Imagem
        try{
            equipeService.saveImage(imageFile);

        } catch(Exception e){
            e.printStackTrace();
            returnValue = "Erro ao salvar a imagem!! Verifique se você selecionou alguma imagem. Tente novamente !!"; 
            return returnValue;
        }

        equipe.setPath(path);
        equipeService.save(equipe);
        
        return "redirect:/dashboard/equipe";
    }



    // Show
    @GetMapping("/dashboard/equipe/detalhes/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        Equipe equipe = equipeService.findById(id);
        model.addAttribute("equipe", equipe);
        return "/dashboard/pages/equipe/detalhes";
    }



    // Edit
    @GetMapping("/dashboard/equipe/editar/{id}")
    public String edit(@PathVariable("id") Long id, Model model)
    {   
        Equipe equipe = equipeService.findById(id);
        model.addAttribute("equipe", equipe);

        return "/dashboard/pages/equipe/editar";
    }

    @RequestMapping("/dashboard/equipe/update/{id}")
    public String update(@Valid Equipe equipe, BindingResult result, RedirectAttributes attributes, HttpServletRequest request, Model model, @RequestParam("imageFile") MultipartFile imageFile)
    {
        if(result.hasErrors()) {
            attributes.addFlashAttribute("error", "Verifique se todos os campos foram preenchidos!");

            return "redirect:/dashboard/equipe/editar/{id}";
        }else{
            attributes.addFlashAttribute("success", "Membro da equipe editado com sucesso!");
        }

        // Imagem
        try{
            String nomeOriginal = imageFile.getOriginalFilename();
            String path = "/img/" + nomeOriginal;
            equipe.setPath(path);
            equipeService.saveImage(imageFile);

        } catch(Exception e){
            // Path
            String path = request.getParameter("path");

            // Cadastro dos dados
            equipe.setPath(path);
            equipeService.save(equipe);
            
            return "redirect:/dashboard/noticias";
        }

        equipeService.save(equipe);
        return "redirect:/dashboard/equipe";
    }



    // Delete
    @RequestMapping("/dashboard/equipe/deletar/{id}")
    public String destroy(@PathVariable("id") Long id, RedirectAttributes attributes){
        attributes.addFlashAttribute("success", "Membrom da equipe deletado com sucesso!");

        equipeService.delete(id);
        return "redirect:/dashboard/equipe";
    }
}
