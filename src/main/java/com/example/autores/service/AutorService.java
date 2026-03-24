package com.exemplo.autores.service;

import com.exemplo.autores.entity.Autor;
import com.exemplo.autores.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private final AutorRepository repository;

    public AutorService(AutorRepository repository) {
        this.repository = repository;
    }

    public Autor salvar(Autor autor) {
        return repository.save(autor);
    }

    public List<Autor> listarTodos() {
        return repository.findAll();
    }

    public Autor buscarPorId(Long id) {
        Optional<Autor> autor = repository.findById(id);
        return autor.orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}