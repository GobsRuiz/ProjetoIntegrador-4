package com.fatec.projetoIntegrador4.controllers.dashboard;

import java.util.List;

import com.fatec.projetoIntegrador4.models.PedirMusica;
import com.fatec.projetoIntegrador4.services.DashControleService;
import com.fatec.projetoIntegrador4.services.PedirMusicaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DashPedirMusica {
    
    // Service
    @Autowired
    private PedirMusicaService pedirMusicaService;
    @Autowired
    private DashControleService dashControleService;
    


    // Index
    @GetMapping("/dashboard/pedidos-musicais")
    public String index(Model model){
        List<PedirMusica> pedirMusicas = pedirMusicaService.findAll();
        model.addAttribute("pedirMusicas", pedirMusicas);

        String verificar = dashControleService.verificarLogin();
        if(verificar != "logado"){
            return "redirect:/dashboard/login";
        }

        return "/dashboard/pages/pedirMusica/index";
    }



    // Show
    @GetMapping("/dashboard/pedidos-musicais/detalhes/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        PedirMusica pedirMusica = pedirMusicaService.findById(id);
        model.addAttribute("pedirMusica", pedirMusica);
        return "/dashboard/pages/pedirMusica/detalhes";
    }



    // Delete
    @RequestMapping("/dashboard/pedidos-musicais/deletar/{id}")
    public String destroy(@PathVariable("id") Long id, RedirectAttributes attributes){
        attributes.addFlashAttribute("success", "Pedido de música deletado com sucesso!");

        pedirMusicaService.delete(id);
        return "redirect:/dashboard/pedidos-musicais";
    }
}
