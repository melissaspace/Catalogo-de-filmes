package com.mbf.trabalho_final.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbf.trabalho_final.entities.Genero;
import com.mbf.trabalho_final.repositories.GeneroRepository;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository repository;
    
    public java.util.List<Genero> listarGeneros() {
        return repository.findAll();
    }

    public Genero buscarGenero(long id_genero) {
        Optional<Genero> optionalGenero = repository.findById(id_genero);
        return optionalGenero.orElseThrow(() -> new RuntimeException());
    }

    public String cadastrarGenero(Genero genero) {
        repository.save(genero);
        return "Gênero inserido com sucesso!";
    }
}
