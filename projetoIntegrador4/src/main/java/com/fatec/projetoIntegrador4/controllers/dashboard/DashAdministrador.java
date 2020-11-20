package com.fatec.projetoIntegrador4.controllers.dashboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.fatec.projetoIntegrador4.models.Administrador;
import com.fatec.projetoIntegrador4.services.AdministradorService;
import com.fatec.projetoIntegrador4.services.DashControleService;

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
public class DashAdministrador {
    
    // Service
    @Autowired
    private AdministradorService administradorService;
    @Autowired
    private DashControleService dashControleService;



    // Index
    @GetMapping("/dashboard/administradores")
    public String index(Model model){
        List<Administrador> administradores = administradorService.findAll();
        model.addAttribute("administradores", administradores);
       
        String verificar = dashControleService.verificarLogin();
        if(verificar != "logado"){
            return "redirect:/dashboard/login";
        }

        return "/dashboard/pages/administradores/index";
    }



    // Store
    @PostMapping("/dashboard/administradores/cadastrar")
    public String store(@Valid Administrador administrador, BindingResult result, RedirectAttributes attributes, HttpServletRequest request){
        if(result.hasErrors()) {
            attributes.addFlashAttribute("error", "Verifique se todos os campos foram preenchidos!");

            return "redirect:/dashboard/administradores";
        }else{
            attributes.addFlashAttribute("success", "Administrador adicionado com sucesso!");
        }

        administradorService.save(administrador);
        return "redirect:/dashboard/administradores";
    }


    
    // Show
    @GetMapping("/dashboard/administradores/detalhes/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        Administrador adm = administradorService.findById(id);
        model.addAttribute("adm", adm);

        return "/dashboard/pages/administradores/detalhes";
    }



    // Edit
    @GetMapping("/dashboard/administradores/editar/{id}")
    public String edit(@PathVariable("id") Long id, Model model)
    {   
        Administrador adm = administradorService.findById(id);
        model.addAttribute("adm", adm);
        
        return "/dashboard/pages/administradores/editar";
    }

    @RequestMapping("/dashboard/administradores/update/{id}")
    public String update(@Valid Administrador administrador, BindingResult result, RedirectAttributes attributes, Model model)
    {
        if(result.hasErrors()) {
            attributes.addFlashAttribute("error", "Verifique se todos os campos foram preenchidos!");

            return "redirect:/dashboard/autores";
        }else{
            attributes.addFlashAttribute("success", "Administrador editado com sucesso!");
        }

        administradorService.save(administrador);
        return "redirect:/dashboard/administradores";
    }



    // Delete
    @RequestMapping("/dashboard/administradores/deletar/{id}")
    public String destroy(@PathVariable("id") Long id, RedirectAttributes attributes){
        attributes.addFlashAttribute("success", "Administrador deletado com sucesso!");

        administradorService.delete(id);
        return "redirect:/dashboard/administradores";
    }
}
