package com.dev.introspringmvc.web.controller;

import com.dev.introspringmvc.dao.UsuarioDao;
import com.dev.introspringmvc.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioDao dao;

    @GetMapping("/todos")
    public ModelAndView listaTodos(ModelMap model){
        model.addAttribute("usuarios", dao.getTodos());
        return new ModelAndView("/user/list", model);
    }

    @GetMapping("/cadastro")
    public String cadastro(@ModelAttribute("usuario") Usuario usuario, ModelMap model){
        return "/user/add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("usuario") Usuario usuario, RedirectAttributes attr){
        dao.salvar(usuario);
        attr.addFlashAttribute("message", "Usuário salvo com sucesso");
        return "redirect:/usuario/todos";
    }
}