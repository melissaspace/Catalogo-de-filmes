package com.mbf.trabalho_final.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbf.trabalho_final.entities.Genero;
import com.mbf.trabalho_final.services.GeneroService;


@RestController
@RequestMapping("/genero")
public class GeneroController {
    @Autowired
    private GeneroService service;
        
    @GetMapping
    public ResponseEntity<List<Genero>> listarGeneros(){
        List<Genero> listaGenero = service.listarGeneros();
        return ResponseEntity.status(HttpStatus.OK).body(listaGenero);
    }

    @GetMapping("/{id_genero}")
    public ResponseEntity<Genero> buscarGenero(@PathVariable long id_genero) {
        Genero response = service.buscarGenero(id_genero);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
        
    @PostMapping
    public ResponseEntity<String> cadastrarGenero(@RequestBody Genero genero){
        String response = service.cadastrarGenero(genero);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
