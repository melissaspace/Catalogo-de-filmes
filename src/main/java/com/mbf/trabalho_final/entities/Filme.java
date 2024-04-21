package com.mbf.trabalho_final.entities;

import org.hibernate.mapping.List;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Coloca o id_filme como autoincrement
    private long id_filme;
    private String titulo;
    private String direcao;
    private String data_lancamento;
    private String sinopse;
    private String classificacao;
    private String img;

    //CONSTRUTORES
    public Filme() {
    }

    //GETTERS
    public long getId_filme() {
        return id_filme;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirecao() {
        return direcao;
    }

    public String getData_lancamento() {
        return data_lancamento;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public String getImg() {
        return img;
    }

    //SETTERS
    public void setId_filme(long id_filme) {
        this.id_filme = id_filme;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public void setData_lancamento(String data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public void setImg(String img) {
        this.img = img;
    }

    //MÉTODOS - INCOMPLETO
    public String cadastrarFilme(long id_filme, String titulo, String direcao, String data_lancamento, String sinopse, String classificacao, String img) {
        setTitulo(titulo);
        setDirecao(direcao);
        setData_lancamento(data_lancamento);
        setSinopse(sinopse);
        setClassificacao(classificacao);
        setImg(img);
        
        //Caso tudo seja preenchido, o úsuario recebe uma mensagem positiva:
        if (titulo != null && direcao != null && data_lancamento != null && sinopse != null && classificacao != null && img != null) {
            return ("Filme cadastrado com sucesso!");
        } else {
            return ("Erro ao cadastrar filme.");
        }
    }

    /* public String alterarFilme() {
        return ("Filme alterado com sucesso!");
    }

    public String removerFime() {
        try {

        } catch () {

        }
    }*/

    public String buscarFilme(long id_filme) {

        //Precisa pegar o Id e mostrar
        return("Id: " + getId_filme() + "\n" +
        "Título: " + getTitulo() + "\n" +
        "Direção: " + getDirecao() + "\n" +
        "Data de lançamento: " + getData_lancamento() + "\n" +
        "Sinopse: " + getSinopse() + "\n" +
        "Classificação: " + getClassificacao() + "\n" +
        "Imagem de capa: " + getImg() );
    }

    @OneToMany
    @JoinColumn (name="id_genero", nullable = false) //Adiciona a chave estrangeira "id_genero" na tabela Filme
    private Genero genero;
    @OneToOne
    //@JoinColumn (name="id_genero", nullable = false)
    //@JsonBackReference
    private Adm adm;
}
