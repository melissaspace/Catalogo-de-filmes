package com.mbf.trabalho_final.services;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mbf.trabalho_final.entities.Filme;
import com.mbf.trabalho_final.repositories.FilmeRepository;

@Service
public class FilmeService {
    @Autowired
    private FilmeRepository repository;
    
    @GetMapping
    public java.util.List<Filme>listar(){
        return repository.findAll();
    }
    
    @PostMapping
    public String salvar(@RequestBody Filme filme){
        repository.save(filme);
        return "Filme salvo com sucesso!";
    }

    @PutMapping
    public String alterar(@RequestBody Filme filme){
        if(filme.getId_filme()>0)
        repository.save(filme);
        return "Filme alterado com sucesso!";
    }

    @DeleteMapping
    public String excluir(@RequestBody Filme filme){
        repository.delete(filme);
        return "Filme excluído com sucesso!";
    }  
}
