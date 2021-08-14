package com.jocimar.bookstore.controller;

import com.jocimar.bookstore.domain.Livro;
import com.jocimar.bookstore.repository.CategoriaRepository;
import com.jocimar.bookstore.repository.LivroRepository;
import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class MainController {
    
   @Autowired 
   private CategoriaRepository  categoriaRepository;
   
   @Autowired
   private LivroRepository livroRepository;

    @GetMapping
    public String init(Model model) {
        
        model.addAttribute("listaCategoria", categoriaRepository.findAll());
        
        
        return "index";
    }

    @PostMapping("/add")
    public String add(HttpServletRequest request, Livro livro,Model model,RedirectAttributes redirectAttributes) throws IOException {

        System.out.println("cheguei");

        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        String content = "";

        try {
            //InputStream inputStream = request.getInputStream();
            //inputStream.available();
            //if (inputStream != null) {
            bufferedReader = request.getReader(); //new BufferedReader(new InputStreamReader(inputStream));
            char[] charBuffer = new char[128];
            int bytesRead;
            while ((bytesRead = bufferedReader.read(charBuffer)) != -1) {
                sb.append(charBuffer, 0, bytesRead);
            }
            //} else {
            //        sb.append("");
            //}

        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }

        try {
            
           
            livroRepository.save(livro); 
            System.out.println(livro.getId());

            
             model.addAttribute("listaCategoria", categoriaRepository.findAll());
             redirectAttributes.addFlashAttribute("message", "Success");
             return "redirect:/livros/"+livro.getId();
        } catch (Exception e) {
            model.addAttribute("erro",e.toString());


            model.addAttribute("listaCategoria", categoriaRepository.findAll());
            redirectAttributes.addFlashAttribute("message", "Failed");
            return "redirect:/";
        }
        
          
       // model.addAttribute("livro", livro);
        
        
     
       

        
    }

}
