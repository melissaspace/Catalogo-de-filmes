package com.mbf.trabalho_final.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_genero;
    private String nome;

    //CONSTRUTORES
    public Genero() {
        setNome(nome);
    }

    //GETTERS
    public long getId_genero() {
        return id_genero;
    }

    public String getNome() {
        return nome;
    }

    //SETTERS
    public void setId_genero(long id_genero) {
        this.id_genero = id_genero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @OneToMany(mappedBy = "genero") //Chave estrangeira gerada na entidade Filme
    private List<Filme> filme;
    
}
