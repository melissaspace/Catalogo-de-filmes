package com.mbf.trabalho_final.services;

import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbf.trabalho_final.entities.Filme;
import com.mbf.trabalho_final.repositories.FilmeRepository;

@Service
public class FilmeService {
    @Autowired
    private FilmeRepository repository;
    
    public java.util.List<Filme> listarFilmes(){
        return repository.findAll();
    }
    
    public Filme buscarFilme(long id_filme) {
        Optional<Filme> optionalFilme = repository.findById(id_filme);
        return optionalFilme.orElseThrow(() -> new RuntimeException());
    }

    public String cadastrarFilme(Filme filme){
        repository.save(filme);
        return "Filme cadastrado com sucesso!";
    }

    public String alterarFilme(long id_filme, Filme filme){
        Optional<Filme> optionalFilme = repository.findById(id_filme);
        if (optionalFilme.isEmpty()) {
            return "Filme não encontrado.";
        }
        Filme filmeExistence = optionalFilme.get();
        filmeExistence.setTitulo(filme.getTitulo());
        filmeExistence.setDirecao(filme.getDirecao());
        filmeExistence.setData_lancamento(filme.getData_lancamento());
        filmeExistence.setSinopse(filme.getSinopse());
        filmeExistence.setClassificacao(filme.getClassificacao());
        filmeExistence.setImg(filme.getImg());

        repository.save(filmeExistence);
        return "Filme alterado com sucesso!";
    }

    public String removerFilme(long id_filme){
        Optional<Filme> optionalFilme = repository.findById(id_filme);

        if (optionalFilme.isEmpty()) {
            return "Filme não encontrado.";
        }
        repository.delete(optionalFilme.get());
        return "Filme excluído com sucesso!";
    }  
}
