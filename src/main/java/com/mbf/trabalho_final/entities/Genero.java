package com.mbf.trabalho_final.entities;

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
    public Genero() {}

    //GETTERS
    public String getNome() {
        return nome;
    }

    //SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }

    //MÉTODOS - INCOMPLETO
    /*public String listarGeneros() {}
    public String removerGenero() {}*/

    @OneToMany(mappedBy = "genero") //Chave estrangeira gerada na entidade Filme
    private Filme filme;
    
}
