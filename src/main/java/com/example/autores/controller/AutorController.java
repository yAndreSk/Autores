package com.example.autores.controller;

import com.example.autores.entity.Autor;
import com.example.autores.service.AutorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService service;

    public AutorController(AutorService service) {
        this.service = service;
    }

    @PostMapping
    public Autor criar(@RequestBody Autor autor) {
        return service.salvar(autor);
    }

    @GetMapping
    public List<Autor> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Autor buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}