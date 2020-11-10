package com.fatec.projetoIntegrador4.controllers.dashboard;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Contato;
import com.fatec.projetoIntegrador4.services.ContatoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashContatoController {

    // Service
    @Autowired
    private ContatoService contatoService;
    


    // Index
    @GetMapping("/dashboard/contato")
    public String index(Model model){
        List<Contato> contatos = contatoService.findAll();
        model.addAttribute("contatos", contatos);

        return "/dashboard/pages/contato/index";
    }



    // Show
    @GetMapping("/dashboard/contato/detalhes/{id}")
    public ModelAndView show(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("/dashboard/pages/contato/detalhes");
        Contato contato = contatoService.findById(id);
        mv.addObject("contato", contato);
        return mv;
    }



    // Delete
    @RequestMapping("/dashboard/contato/deletar/{id}")
    public String destroy(@PathVariable("id") Long id) {
        contatoService.delete(id);
        return "redirect:/dashboard/contato";
    }
}
