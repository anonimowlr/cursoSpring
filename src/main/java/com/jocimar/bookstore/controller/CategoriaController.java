package com.jocimar.bookstore.controller;


import com.jocimar.bookstore.domain.Categoria;
import com.jocimar.bookstore.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("categoria")
@Controller
public class CategoriaController {

    @Autowired
   private CategoriaRepository categoriaRepository;

    @GetMapping
    public String init(){

        return  "gerenciar-categoria";
    }



    @PostMapping("/add")
    public String add(Categoria categoria, RedirectAttributes redirectAttributes){

        try{
            categoriaRepository.save(categoria);
            redirectAttributes.addFlashAttribute("message", "Success");
            return "redirect:/";
        } catch (Exception e){
            redirectAttributes.addFlashAttribute("message", e.toString());
            return "error";

        }



    }

}
