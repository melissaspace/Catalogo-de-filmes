package com.mbf.trabalho_final.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    //CONSTRUTORES
    public Filme() {
       setTitulo(titulo);
        setDirecao(direcao);
        setData_lancamento(data_lancamento);
        setSinopse(sinopse);
        setClassificacao(classificacao);
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


    @ManyToOne
    @JoinColumn (name="id_genero", nullable = false) //Adiciona a chave estrangeira "id_genero" na tabela Filme
    private Genero genero;
    @OneToOne
    //@JoinColumn (name="id_genero", nullable = false)
    //@JsonBackReference
    private Adm adm;
}
