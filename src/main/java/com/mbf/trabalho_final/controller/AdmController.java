package com.mbf.trabalho_final.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbf.trabalho_final.entities.Adm;
import com.mbf.trabalho_final.services.AdmService;

@RestController
@RequestMapping("/Adm")
public class AdmController {

    @Autowired
    private AdmService service;
        
    @GetMapping
    public ResponseEntity<List<Adm>> listarAdms(){
        List<Adm> listaAdm = service.listarAdms();
        return ResponseEntity.status(HttpStatus.OK).body(listaAdm);
    }
        
    @PostMapping
    public ResponseEntity<String> cadastrarAdm(@RequestBody Adm adm){
        String response = service.cadastrarAdm(adm);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{user_name}")
    public ResponseEntity<String> alterarAdm(@PathVariable long id_adm, @RequestBody Adm adm){
        String response = service.alterarAdm(id_adm, adm);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{user_name}")
    public ResponseEntity<String> removerAdm(@PathVariable long id_adm){
        String response = service.removerAdm(id_adm);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

