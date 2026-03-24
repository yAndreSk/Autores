package com.exemplo.autores.controller;

import com.exemplo.autores.entity.Autor;
import com.exemplo.autores.service.AutorService;
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