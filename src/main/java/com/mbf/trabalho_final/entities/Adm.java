package com.mbf.trabalho_final.entities;


import java.util.List;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Adm {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String user_name;
    private String senha;
    private String status_login;

    public Adm() {
        setUser_name(user_name);
        setSenha(senha);
        setStatus_login(status_login);
    }

    //GETTERS
    public String getUser_name() {
        return user_name;
    }

    public String getSenha() {
        return senha;
    }

    public String getStatus_login() {
        return status_login;
    }

    //SETTERS
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setStatus_login(String status_login) {
        this.status_login = status_login;
    }

    //MÉTODOS - INCOMPLETO
   /* public void logar() {}
    public boolean verificarLogin(String user_name, String senha) {
        setUser_name(user_name);
        setSenha(senha);
        //verificar se não é necessário um atributo que guarda o boolean
        if ((user_name != null && senha != null) && (user_name == this.user_name && senha == this.senha)) {
            return (true);
        } return (false);
    }*/
    @OneToMany
    private List <Filme> filme;

}