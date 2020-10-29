package com.dev.introspringmvc.web.controller;

import com.dev.introspringmvc.dao.UsuarioDao;
import com.dev.introspringmvc.domain.TipoSexo;
import com.dev.introspringmvc.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
        model.addAttribute("sexos", TipoSexo.values());
        return "/user/add";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, RedirectAttributes attr){
        if(result.hasErrors()){
            return "user/add";
        }
        dao.salvar(usuario);
        attr.addFlashAttribute("message", "Usuário salvo com sucesso");
        return "redirect:/usuario/todos";
    }

    @GetMapping("/update/{id}")
    public ModelAndView preUpdate(@PathVariable("id") Long id, ModelMap model){
        Usuario usuario = dao.getId(id);

        model.addAttribute("usuario", usuario);
        return new ModelAndView("/user/add", model);
    }

    @PostMapping("/update")
    public ModelAndView update(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, RedirectAttributes attr){
        if(result.hasErrors()) return new ModelAndView("user/add");

        dao.editar(usuario);
        attr.addFlashAttribute("message", "Usuário atualizado com sucesso");
        return new ModelAndView("redirect:/usuario/todos");
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes attr){
        dao.excluir(id);
        attr.addFlashAttribute("message", "Usuário excluído com sucesso;");
        return "redirect:/usuario/todos";
    }
}
