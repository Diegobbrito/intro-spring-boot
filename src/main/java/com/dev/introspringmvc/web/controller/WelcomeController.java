package com.dev.introspringmvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String welcome(){
        System.out.println("Fui chamado");
        return "welcome";
    }

    @GetMapping("/teste")
    public ModelAndView teste(){
        ModelAndView view = new ModelAndView("welcome");
        view.addObject("teste", "Spring MVC");
        System.out.println("Fui chamado no teste");
        return view;
    }

}
