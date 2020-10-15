package com.fatec.projetoIntegrador4.controllers;

import java.util.List;

import javax.validation.Valid;

import com.fatec.projetoIntegrador4.models.Contact;
import com.fatec.projetoIntegrador4.services.ContactService;

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
// @RequestMapping("/teste/contato")
public class ContactController {

    // Service
    @Autowired
    private ContactService contactService;
    


    // Index
    @GetMapping("/teste/contato")
    public ModelAndView index()
    {
        ModelAndView mv = new ModelAndView("test/contact/index");
        List<Contact> contacts = contactService.findAll();
        mv.addObject("contacts", contacts);
        return mv;
    }



    // Store
    @GetMapping("/teste/contato/cadastrar")
    public String form(Contact contact, Model model)
    {
        model.addAttribute(contact);
        return "test/contact/store";
    }

    @PostMapping("/teste/contato/cadastrar")
    public String store(@Valid Contact contact, BindingResult result, RedirectAttributes attributes, Model model)
    {
        if(result.hasErrors()){
            return "redirect:/teste/contato/cadastrar";
        }
        
        contactService.save(contact);
        return "redirect:/teste/contato";
    }



    // Show
    @GetMapping("/teste/contato/detalhes/{id}")
    public ModelAndView show(@PathVariable("id") Long id)
    {
        ModelAndView mv = new ModelAndView("test/contact/show");
        Contact contact = contactService.findById(id);
        mv.addObject("contact", contact);
        return mv;
    }



    // Delete
    @RequestMapping("/teste/contato/deletar/{id}")
    public String destroy(@PathVariable("id") Long id)
    {
        contactService.delete(id);
        return "redirect:/teste/contato";
    }
}
