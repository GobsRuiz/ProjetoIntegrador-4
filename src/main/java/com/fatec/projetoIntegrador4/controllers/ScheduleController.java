package com.fatec.projetoIntegrador4.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.fatec.projetoIntegrador4.models.Schedule;
import com.fatec.projetoIntegrador4.models.Team;
import com.fatec.projetoIntegrador4.services.ScheduleService;
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
public class ScheduleController {
    
    // Service
    // Service Schedule
    @Autowired
    private ScheduleService scheduleService;

    // Service team
    @Autowired
    private TeamService teamService;


    
    // Index
    @GetMapping("/teste/programas")
    public ModelAndView index()
    {
        ModelAndView mv = new ModelAndView("test/schedule/index");
        List<Schedule> schedules = scheduleService.findAll();
        mv.addObject("schedules", schedules);
        return mv;
    }



    // Store
    @GetMapping("/teste/programas/cadastrar")
    public String form(Model model)
    {
        List<Team> teams = teamService.findAll();
        model.addAttribute("teams", teams);
        return "test/schedule/store";
    }

    @PostMapping("/teste/programas/cadastrar")
    public String store(@Valid Schedule schedule, BindingResult result, RedirectAttributes attributes, HttpServletRequest request)
    {
        if(result.hasErrors()){
            attributes.addFlashAttribute("error", "Verifique se todos os campos foram preenchidos");
            return "redirect:/teste/programas/cadastrar";
        }

        // Team id
        Long teamid = Long.parseLong(request.getParameter("team_id"));
        
        // Schedule registration
        schedule.setName(request.getParameter("name"));
        schedule.setStyle(request.getParameter("style"));
        schedule.setHour(request.getParameter("hour"));
        schedule.setSegmentation(request.getParameter("segmentation"));
        schedule.setTeam(teamService.findById(teamid));
        scheduleService.save(schedule);

        return "redirect:/teste/programas";
    }



    // Show
    @GetMapping("/teste/programas/detalhes/{id}")
    public ModelAndView show(@PathVariable("id") Long id)
    {
        ModelAndView mv = new ModelAndView("test/schedule/show");
        Schedule schedule = scheduleService.findById(id);
        mv.addObject("schedule", schedule);
        return mv;
    }



    // Edit or Update
    @GetMapping("/teste/programas/editar/{id}")
    public String edit(@PathVariable("id") Long id, Model model)
    {   
        List<Team> teams = teamService.findAll();
        model.addAttribute("teams", teams);

        Schedule schedule = scheduleService.findById(id);
        model.addAttribute("schedule", schedule);

        return "test/schedule/edit";
    }

    @RequestMapping("/teste/programas/editar/{id}")
    public String update(HttpServletRequest request ,@PathVariable("id") Long id)
    {

        // Team id
        
        // Schedule registration
        Schedule schedule = scheduleService.findById(id);
        schedule.setName(request.getParameter("name"));
        schedule.setStyle(request.getParameter("style"));
        schedule.setHour(request.getParameter("hour"));
        schedule.setSegmentation(request.getParameter("segmentation"));
        scheduleService.save(schedule);

        return "redirect:/teste/programas";
    }


    // Delete
    @RequestMapping("/teste/programas/deletar/{id}")
    public String destroy(@PathVariable("id") Long id)
    {
        scheduleService.delete(id);
        return "redirect:/teste/programas";
    }
}
