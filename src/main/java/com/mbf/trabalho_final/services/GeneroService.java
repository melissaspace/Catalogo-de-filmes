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

    public String alterarGenero(long id_genero, Genero genero){
        Optional<Genero> optionalgenero = repository.findById(id_genero);
        if (optionalgenero.isEmpty()) {
            return "genero não encontrado.";
        }
        Genero generoExistence = optionalgenero.get();
        generoExistence.setId_genero(genero.getId_genero());
        generoExistence.setNome(genero.getNome());

        repository.save(generoExistence);
        return "Genero alterado com sucesso!";
    }

    public String removerGenero(long id_genero){
        Optional<Genero> optionalGenero = repository.findById(id_genero);

        if (optionalGenero.isEmpty()) {
            return "Genero não encontrado.";
        }
        repository.delete(optionalGenero.get());
        return "Genero excluído com sucesso!";
    }  
}
