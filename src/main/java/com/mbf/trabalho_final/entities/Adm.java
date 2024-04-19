package com.mbf.trabalho_final.entities;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity

public class Adm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String user_name;
    private String senha;
    private String status_login;

    @OneToMany (mappedBy = "adm")
    private List <Filme> filme;

}