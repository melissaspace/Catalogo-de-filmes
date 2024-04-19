package com.mbf.trabalho_final.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id_filme;
    private String titulo;
    private String direcao;
    private String data_lancamento;
    private String sinopse;
    private long id_genero;
    private String classificacao;
    private String img;

    @OneToOne
    //@JoinColumn (name="adm_id", nullable = false)
    @JsonBackReference
    private Adm adm;
}
