package com.fatec.projetoIntegrador4.controllers.dashboard;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.fatec.projetoIntegrador4.models.Autor;
import com.fatec.projetoIntegrador4.models.Noticia;
import com.fatec.projetoIntegrador4.repositorys.NoticiaRepository;
import com.fatec.projetoIntegrador4.services.AutorService;
import com.fatec.projetoIntegrador4.services.DashControleService;
import com.fatec.projetoIntegrador4.services.NoticiaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DashNoticiaController {
    
    // Service
    @Autowired
    private NoticiaService noticiaService;
    @Autowired
    private NoticiaRepository noticiaRepository;
    @Autowired
    private AutorService autorService;
    @Autowired
    private DashControleService dashControleService;
    


    // Index
    @GetMapping("/dashboard/noticias")
    public String index(Model model){
        List<Noticia> noticias = noticiaService.findAll();
        model.addAttribute("noticias", noticias);

        List<Autor> autores = autorService.findAll();
        model.addAttribute("autores", autores);

        String verificarLogin = dashControleService.verificarLogin();
        model.addAttribute("verificarLogin", verificarLogin);

        return "/dashboard/pages/noticias/index";
    }



    // Store
    @PostMapping("/dashboard/noticias/cadastrar")
    public String store(@Valid Noticia noticia, BindingResult result, RedirectAttributes attributes, HttpServletRequest request, @RequestParam("imageFile") MultipartFile imageFile) {
        
        // Mensagem
        if(result.hasErrors()){
            attributes.addFlashAttribute("error", "Verifique se todos os campos foram preenchidos!");
            return "redirect:/dashboard/noticias";
        }else{
            attributes.addFlashAttribute("success", "Nóticia criada com sucesso!");
        }

        // Variáveis
        String titulo = request.getParameter("titulo");
        String texto = request.getParameter("texto");
        Long id = Long.parseLong(request.getParameter("autor_id")); 
        Autor autor = autorService.findById(id);
        String nomeOriginal = imageFile.getOriginalFilename();
        String path = "/img/" + nomeOriginal;
        String returnValue = "start";

        // Imagem
        try{
            noticiaService.saveImage(imageFile);

        } catch(Exception e){
            e.printStackTrace();
            returnValue = "erro parceiro"; 
            return returnValue;
        }

        // Date
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
        Date date = new Date(); 
        
        // Cadasto dos outros dados
        noticia.setTitulo(titulo);
        noticia.setTexto(texto);
        noticia.setData(dateFormat.format(date));
        noticia.setPath(path);
        noticia.setAutor(autor);
        noticiaService.save(noticia);
        
        return "redirect:/dashboard/noticias";
    }



    // Show
    @GetMapping("/dashboard/noticias/detalhes/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        Noticia noticia = noticiaService.findById(id);
        model.addAttribute("noticia", noticia);
        return "/dashboard/pages/noticias/detalhes";
    }



    // Edit
    @GetMapping("/dashboard/noticias/editar/{id}")
    public String edit(@PathVariable("id") Long id, Model model)
    {   
        Noticia noticia = noticiaService.findById(id);
        model.addAttribute("noticia", noticia);

        List<Autor> autores = autorService.findAll();
        model.addAttribute("autores", autores);

        return "/dashboard/pages/noticias/editar";
    }

    @RequestMapping("/dashboard/noticias/update/{id}")
    public String update(@Valid Noticia noticia, BindingResult result, RedirectAttributes attributes, Model model, HttpServletRequest request, @RequestParam("imageFile") MultipartFile imageFile)
    {
        if(result.hasErrors()) {
            attributes.addFlashAttribute("error", "Verifique se todos os campos foram preenchidos!");

            return "redirect:/dashboard/noticias/editar/{id}";
        }else{
            attributes.addFlashAttribute("success", "Nóticia editada com sucesso!");
        }

        // Variáveis
        String titulo = request.getParameter("titulo");
        String texto = request.getParameter("texto");
        Long id = Long.parseLong(request.getParameter("autor_id")); 
        Autor autor = autorService.findById(id);
        String returnValue = "start";

        // Imagem
        try{
            String nomeOriginal = imageFile.getOriginalFilename();
            String path = "/img/" + nomeOriginal;
            noticia.setPath(path);
            noticiaService.saveImage(imageFile);

        } catch(Exception e){
            // Path
            String path = request.getParameter("path");

            // Date
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
            Date date = new Date(); 
            
            // Cadastro dos dados
            noticia.setTitulo(titulo);
            noticia.setPath(path);
            noticia.setTexto(texto);
            noticia.setData(dateFormat.format(date));
            noticia.setAutor(autor);
            noticiaService.save(noticia);

            return "redirect:/dashboard/noticias";
        }

        // Date
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
        Date date = new Date(); 
        
        // Cadastro dos outros dados
        noticia.setTitulo(titulo);
        noticia.setTexto(texto);
        noticia.setData(dateFormat.format(date));
        noticia.setAutor(autor);
        noticiaService.save(noticia);

        return "redirect:/dashboard/noticias";
    }



    // Delete
    @RequestMapping("/dashboard/noticias/deletar/{id}")
    public String destroy(@PathVariable("id") Long id, RedirectAttributes attributes) {
        attributes.addFlashAttribute("success", "Noticia deletada com sucesso!");

        noticiaService.delete(id);
        return "redirect:/dashboard/noticias";
    }
}
