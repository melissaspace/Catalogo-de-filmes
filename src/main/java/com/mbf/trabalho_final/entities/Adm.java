package com.mbf.trabalho_final.entities;


import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Adm implements UserDetails {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String user_name;
    private String senha;

    public Adm() {
        /*setUser_name(user_name);
        setSenha(senha);*/
    }

    //GETTERS
    public String getUser_name() {
        return user_name;
    }

    public String getSenha() {
        return senha;
    }

    //SETTERS
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @OneToMany
    private List <Filme> filme;

}