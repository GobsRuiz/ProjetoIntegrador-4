package com.fatec.projetoIntegrador4.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.fatec.projetoIntegrador4.models.Team;
import com.fatec.projetoIntegrador4.services.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TeamController {

    // Service
    @Autowired
    private TeamService teamService;


    
    // Index
    @GetMapping("/teste/equipe")
    public ModelAndView index()
    {
        ModelAndView mv = new ModelAndView("test/team/index");
        List<Team> teams = teamService.findAll();
        mv.addObject("teams", teams);
        return mv;
    }



    // Store
    @GetMapping("/teste/equipe/cadastrar")
    public String form()
    {
        return "test/team/store";
    }

    @PostMapping("/teste/equipe/cadastrar")
    public String store(@Valid Team team, BindingResult result, RedirectAttributes attributes, Model model)
    {
        if(result.hasErrors()){
            attributes.addFlashAttribute("error", "Verifique se todos os campos foram preenchidos");
            return "redirect:/teste/equipe/cadastrar";
        }
        
        teamService.save(team);
        return "redirect:/teste/equipe";
    }



    // Show
    @GetMapping("/teste/equipe/detalhes/{id}")
    public ModelAndView show(@PathVariable("id") Long id)
    {
        ModelAndView mv = new ModelAndView("test/team/show");
        Team team = teamService.findById(id);
        mv.addObject("team", team);
        return mv;
    }



    // Edit or Update
    @GetMapping("/teste/equipe/editar/{id}")
    public ModelAndView edit(@PathVariable("id") Long id)
    {
        ModelAndView mv = new ModelAndView("test/team/edit");
        Team team = teamService.findById(id);
        mv.addObject("team", team);
        return mv;
    }

    @RequestMapping("/teste/equipe/editar/{id}")
    public String update(HttpServletRequest request ,@PathVariable("id") Long id)
    {
        Team team = teamService.findById(id);
        team.setName(request.getParameter("name")); 
        team.setRole(request.getParameter("role")); 
        teamService.save(team);

        return "redirect:/teste/equipe";
    }


    // Delete
    @RequestMapping("/teste/equipe/deletar/{id}")
    public String destroy(@PathVariable("id") Long id)
    {
        teamService.delete(id);
        return "redirect:/teste/equipe";
    }
}
