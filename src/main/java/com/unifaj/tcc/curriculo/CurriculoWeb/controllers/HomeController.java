package com.unifaj.tcc.curriculo.CurriculoWeb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("nome","Jose");
        

        return "home/login";
    }
}
