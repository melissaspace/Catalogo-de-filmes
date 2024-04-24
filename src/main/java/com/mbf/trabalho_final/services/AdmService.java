package com.mbf.trabalho_final.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbf.trabalho_final.entities.Adm;
import com.mbf.trabalho_final.repositories.AdmRepository;

@Service
public class AdmService {
    @Autowired
    private AdmRepository repository;
    
    public java.util.List<Adm> listarAdms(){
        return repository.findAll();
    }

    public String cadastrarAdm(Adm adm){
        repository.save(adm);
        return "Administrador cadastrado com sucesso!";
    }

    public String alterarAdm(String user_name, Adm adm){
        Optional<Adm> optionalAdm = repository.findById(user_name);

        if (optionalAdm.isEmpty()) {
            return "Administrador não encontrado.";
        }
        Adm admExistence = optionalAdm.get();
        admExistence.setUser_name(adm.getUser_name());
        admExistence.setSenha(adm.getSenha());
    
        repository.save(admExistence);
        return "Administrador alterado com sucesso!";
    }

    public String removerAdm(String user_name){
        Optional<Adm> optionalAdm = repository.findById(user_name);

        if (optionalAdm.isEmpty()) {
            return "Administrador não encontrado.";
        }

        repository.delete(optionalAdm.get());
        return "Administrador excluído com sucesso!";
    }
}
