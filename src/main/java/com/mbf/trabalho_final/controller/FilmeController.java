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

import com.mbf.trabalho_final.entities.Filme;
import com.mbf.trabalho_final.repositories.FilmeRepository;
import com.mbf.trabalho_final.services.FilmeService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/filme")
public class FilmeController {
    @Autowired
    private FilmeService service;
        
    @GetMapping
    public ResponseEntity<List<Filme>> listarFilmes(){
        List<Filme> listaFilme = service.listarFilmes();
        return ResponseEntity.status(HttpStatus.OK).body(listaFilme);
    }

    @GetMapping("/{id_filme}")
    public ResponseEntity<Filme> buscarFilme(@PathVariable long id_filme) {
        Filme response = service.buscarFilme(id_filme);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
        
    @PostMapping
    public ResponseEntity<String> cadastrarFilme(@RequestBody Filme filme){
        String response = service.cadastrarFilme(filme);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id_filme}")
    public ResponseEntity<String> alterarFilme(@PathVariable long id_filme, @RequestBody Filme filme){
        String response = service.alterarFilme(id_filme, filme);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id_filme}")
    public ResponseEntity<String> removerFilme(@PathVariable long id_filme){
        String response = service.removerFilme(id_filme);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}