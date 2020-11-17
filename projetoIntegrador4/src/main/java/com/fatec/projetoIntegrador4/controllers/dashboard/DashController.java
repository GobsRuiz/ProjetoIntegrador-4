package com.fatec.projetoIntegrador4.controllers.dashboard;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.fatec.projetoIntegrador4.models.Administrador;
import com.fatec.projetoIntegrador4.services.AdministradorService;
import com.fatec.projetoIntegrador4.services.DashControleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DashController {
    
    // Service
    @Autowired
    private AdministradorService administradorService;
    @Autowired
    private DashControleService dashControleService;
    


    // Index
    @GetMapping("/dashboard/login")
    public String index(Model model) {
        String name = "";

        List<Administrador> administradores = administradorService.findAll();
        // ArrayList admArray =  new ArrayList<>(administradores);

        for (Administrador obj : administradores) {
            name = String.format("" + obj.getName());
        }

        model.addAttribute("name", name);
        model.addAttribute("administradores", administradores);
        
        dashControleService.mudarValor("nao logado");
        return "//dashboard/pages/login/index";
    }
    


    // Login
    @PostMapping("/dashboard/login/login")
    public String login(HttpServletRequest request) {
        return "redirect:/dashboard/login";
    }
}
