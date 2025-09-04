package com.ranieriiuri.taskManagerUninterProject.controller;

import com.ranieriiuri.taskManagerUninterProject.entity.Tarefa;
import com.ranieriiuri.taskManagerUninterProject.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService service;

    List<Tarefa> tarefas = new ArrayList<>();

    @GetMapping("/cadastro")
    public String cadastro(Tarefa tarefa) {
        return "tarefa/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Tarefa tarefa, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/tarefa/cadastro";
        }
        service.salvar(tarefa);
        attr.addFlashAttribute("success", "Tarefa salva com sucesso.");
        return "redirect:/tarefas/lista";
    }

    @GetMapping("/lista")
    public String lista(ModelMap model) {
        model.addAttribute("tarefas", service.buscaTodos());
        return "tarefa/lista";
    }

    @PostMapping("/editar")
    public String editar(@Valid Tarefa tarefa, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/tarefa/cadastro";
        }
        service.editar(tarefa);
        attr.addFlashAttribute("success", "Tarefa atualizada com sucesso.");
        return "redirect:/tarefas/cadastro";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model ) {

        service.excluir(id);
        model.addAttribute("success", "Tarefa excluída.");
        return lista(model);
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("tarefa", service.buscarPorId(id));

        return "/tarefa/cadastro";
    }

}
