package com.fatec.projetoIntegrador4.controllers.dashboard;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import com.fatec.projetoIntegrador4.models.Administrador;
import com.fatec.projetoIntegrador4.services.AdministradorService;
import com.fatec.projetoIntegrador4.services.DashControleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DashController {
    
    // Service
    @Autowired
    private AdministradorService administradorService;
    @Autowired
    private DashControleService dashControleService;
    


    // Index
    @GetMapping("/dashboard")
    public String index(Model model) {
        String verificarLogin = dashControleService.verificarLogin();
        model.addAttribute("verificarLogin", verificarLogin);

        return "//dashboard/pages/index/index";
    }



    // Login
    @GetMapping("/dashboard/login")
    public String indexLogin(Model model) {

        String verificarLogin = dashControleService.verificarLogin();
        model.addAttribute("verificarLogin", verificarLogin);
        
        return "//dashboard/pages/login/index";
    }
    @PostMapping("/dashboard/login/login")
    public String login(HttpServletRequest request, BindingResult result, RedirectAttributes attributes) {
        if(result.hasErrors()) {
            attributes.addFlashAttribute("error", "Nome ou senha errada!");

            return "redirect:/dashboard/login";
        }else{
            attributes.addFlashAttribute("success", "Logado!");
        }

        String name = String.format("" + request.getParameter("name"));
        String password = String.format("" + request.getParameter("password"));
        List<Administrador> administradores = administradorService.findAll();
        for (Administrador obj : administradores) {
            if(name.equals(obj.getName()) && password.equals(obj.getPassword())){
                dashControleService.mudarValor("logado");
                return "redirect:/dashboard";
            }
        }
        return "redirect:/dashboard/login";
    }
    


    // Get out
    @RequestMapping("/dashboard/sair")
    public String getOut(){
        dashControleService.mudarValor("nao logado");
        return "redirect:/dashboard/login";
    }
}
