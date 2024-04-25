package com.mbf.trabalho_final.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Adm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_adm;
    private String user_name;
    private String senha;

    public Adm() {
        setId_adm(id_adm);
        setUser_name(user_name);
        setSenha(senha);
    }

    //GETTERS
    public long getId_adm() {
        return id_adm;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getSenha() {
        return senha;
    }

    //SETTERS
    public void setId_adm(long id_adm) {
        this.id_adm = id_adm;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @OneToMany
    private List <Filme> filme;

}