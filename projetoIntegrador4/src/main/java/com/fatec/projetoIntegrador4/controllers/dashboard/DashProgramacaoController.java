package com.fatec.projetoIntegrador4.controllers.dashboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.fatec.projetoIntegrador4.models.Equipe;
import com.fatec.projetoIntegrador4.models.Programacao;
import com.fatec.projetoIntegrador4.services.DashControleService;
import com.fatec.projetoIntegrador4.services.EquipeService;
import com.fatec.projetoIntegrador4.services.ProgramacaoService;

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
public class DashProgramacaoController {

    // Service
    @Autowired
    private ProgramacaoService programacaoService;
    @Autowired
    private EquipeService equipeService;
    @Autowired
    private DashControleService dashControleService;



    // Index
    @GetMapping("/dashboard/programas")
    public String index(Model model){
        List<Programacao> programas = programacaoService.findAll();
        model.addAttribute("programas", programas);

        List<Equipe> equipes = equipeService.findAll();
        model.addAttribute("equipes", equipes);

        String verificarLogin = dashControleService.verificarLogin();
        model.addAttribute("verificarLogin", verificarLogin);
        
        return "/dashboard/pages/programas/index";
    }



    // Store
    @PostMapping("/dashboard/programas/cadastrar")
    public String storeProgramacao(@Valid Programacao programacao, HttpServletRequest request, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()) {
            attributes.addFlashAttribute("error", "Verifique se todos os campos foram preenchidos!");

            return "redirect:/dashboard/programas";
        }else{
            attributes.addFlashAttribute("success", "Programa adicionado com sucesso!");
        }

        // Variáveis
        String name = request.getParameter("name");
        String estilo = request.getParameter("estilo");
        String horario = request.getParameter("horario");
        String periodo = request.getParameter("periodo");
        String segmentacao = request.getParameter("segmentacao");
        Long id = Long.parseLong(request.getParameter("equipe_id")); 
        Equipe equipe = equipeService.findById(id);

        // Cadastro
        programacao.setName(name);
        programacao.setEstilo(estilo);
        programacao.setHorario(horario);
        programacao.setPeriodo(periodo);
        programacao.setSegmentacao(segmentacao);
        programacao.setEquipe(equipe);
        programacaoService.save(programacao);

        return "redirect:/dashboard/programas";
    }



    // Show
    @GetMapping("/dashboard/programas/detalhes/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        Programacao programa = programacaoService.findById(id);
        model.addAttribute("programa", programa);
        return "/dashboard/pages/programas/detalhes";
    }



    // Edit
    @GetMapping("/dashboard/programas/editar/{id}")
    public String edit(@PathVariable("id") Long id, Model model)
    {   
        Programacao programa = programacaoService.findById(id);
        model.addAttribute("programa", programa);

        List<Equipe> equipes = equipeService.findAll();
        model.addAttribute("equipes", equipes);

        return "/dashboard/pages/programas/editar";
    }

    @RequestMapping("/dashboard/programas/update/{id}")
    public String update(@Valid Programacao programacao, BindingResult result, RedirectAttributes attributes, HttpServletRequest request, Model model)
    {
        if(result.hasErrors()) {
            attributes.addFlashAttribute("error", "Verifique se todos os campos foram preenchidos!");

            return "redirect:/dashboard/programas/editar/{id}";
        }else{
            attributes.addFlashAttribute("success", "Programa editado com sucesso!");
        }

        // Variáveis
        String name = request.getParameter("name");
        String estilo = request.getParameter("estilo");
        String horario = request.getParameter("horario");
        String periodo = request.getParameter("periodo");
        String segmentacao = request.getParameter("segmentacao");
        Long id = Long.parseLong(request.getParameter("equipe")); 
        Equipe equipe = equipeService.findById(id);

        // Cadastro
        programacao.setName(name);
        programacao.setEstilo(estilo);
        programacao.setHorario(horario);
        programacao.setPeriodo(periodo);
        programacao.setSegmentacao(segmentacao);
        programacao.setEquipe(equipe);
        programacaoService.save(programacao);
        attributes.addFlashAttribute("success", "Editado com sucesso!");

        return "redirect:/dashboard/programas";
    }



    // Delete
    @RequestMapping("/dashboard/programas/deletar/{id}")
    public String destroy(@PathVariable("id") Long id, RedirectAttributes attributes) {
        attributes.addFlashAttribute("success", "Programa deletado com sucesso!");

        programacaoService.delete(id);
        return "redirect:/dashboard/programas";
    }
}
