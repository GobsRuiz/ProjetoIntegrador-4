package com.fatec.projetoIntegrador4.controllers.dashboard;

import java.util.List;

import javax.validation.Valid;

import com.fatec.projetoIntegrador4.models.PedirMusica;
import com.fatec.projetoIntegrador4.services.PedirMusicaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DashPedirMusica {
    
    // Service
    @Autowired
    private PedirMusicaService pedirMusicaService;
    


    // Index
    @GetMapping("/dashboard/pedir-musica")
    public String index(Model model){
        List<PedirMusica> pedirMusicas = pedirMusicaService.findAll();
        model.addAttribute("pedirMusicas", pedirMusicas);

        return "/dashboard/pages/pedirMusica/index";
    }



    // Show
    @GetMapping("/dashboard/pedir-musica/detalhes/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        PedirMusica pedirMusica = pedirMusicaService.findById(id);
        model.addAttribute("pedirMusica", pedirMusica);
        return "/dashboard/pages/pedirMusica/detalhes";
    }



    // Edit
    // @GetMapping("/dashboard/pedir-musica/editar/{id}")
    // public String edit(@PathVariable("id") Long id, Model model)
    // {   
    //     PedirMusica pedirMusica = pedirMusicaService.findById(id);
    //     model.addAttribute("pedirMusica", pedirMusica);

    //     return "dashboard/pages/pedirMusica/editar";
    // }

    // @RequestMapping("/dashboard/pedir-musica/editar/{id}")
    // public String update(@Valid PedirMusica pedirMusica, BindingResult result, RedirectAttributes attributes, Model model)
    // {
    //     if(result.hasErrors()) {
    //         attributes.addFlashAttribute("error", "Verifique se os campos obrigatórios foram preenchidos!");

    //         return "redirect:/dashboard/pedir-musica/editar/{id}";
    //     }else{
    //         pedirMusicaService.save(pedirMusica);
    //         attributes.addFlashAttribute("success", "Editado com sucesso!");

    //         return "redirect:/dashboard/pedir-musica";
    //     }

    // }



    // Delete
    @RequestMapping("/dashboard/pedir-musica/deletar/{id}")
    public String destroy(@PathVariable("id") Long id) {
        pedirMusicaService.delete(id);
        return "redirect:/dashboard/pedir-musica";
    }
}
