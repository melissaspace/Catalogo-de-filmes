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

    public Adm buscarAdm(long id_adm) {
        Optional<Adm> optionalAdm = repository.findById(id_adm);
        return optionalAdm.orElseThrow(() -> new RuntimeException());
    }

    public String cadastrarAdm(Adm adm){
        repository.save(adm);
        return "Administrador cadastrado com sucesso!";
    }

    public String alterarAdm(long id_adm, Adm adm){
        Optional<Adm> optionalAdm = repository.findById(id_adm);

        if (optionalAdm.isEmpty()) {
            return "Administrador não encontrado.";
        }
        Adm admExistence = optionalAdm.get();
        admExistence.setId_adm(adm.getId_adm());
        admExistence.setUser_name(adm.getUser_name());
        admExistence.setSenha(adm.getSenha());
    
        repository.save(admExistence);
        return "Administrador alterado com sucesso!";
    }

    public String removerAdm(long id_adm){
        Optional<Adm> optionalAdm = repository.findById(id_adm);

        if (optionalAdm.isEmpty()) {
            return "Administrador não encontrado.";
        }

        repository.delete(optionalAdm.get());
        return "Administrador excluído com sucesso!";
    }
}
