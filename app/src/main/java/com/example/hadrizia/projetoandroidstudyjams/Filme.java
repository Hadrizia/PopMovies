package com.example.hadrizia.projetoandroidstudyjams;

import java.io.Serializable;
import java.util.List;


/**
 * Created by HADRIZIA on 26/04/2016.
 */
public class Filme implements Serializable {
    String id;
    String titulo;
    String endereco_poster;
    String ano;
    String duracao;
    String nota;
    boolean favorito;
    String descricao;
    String endereco_trailer1;
    String endereco_trailer2;


    public Filme(String id, String titulo, String endereco_poster, String ano, String duracao, String nota, boolean favorito, String descricao,
                 String endereco_trailer1, String endereco_trailer2){
        setId(id);
        setTitulo(titulo);
        setEndereco_poster(endereco_poster);
        setAno(ano);
        setDuracao(duracao);
        setNota(nota);
        setFavorito(favorito);
        setDescricao(descricao);
        setEndereco_trailer1(endereco_trailer1);
        setEndereco_trailer2(endereco_trailer2);
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public void setEndereco_poster(String endereco_poster){
        this.endereco_poster = endereco_poster;
    }

    public String getEndereco_poster(){
        return this.endereco_poster;
    }

    public void setAno(String ano){
        this.ano = ano;
    }

    public String getAno(){
        return this.ano;
    }

    public void setNota(String nota){ this.nota = nota; }

    public String getNota(){ return this.nota;}

    public void setDuracao(String duracao){
        this.duracao = duracao;
    }

    public String getDuracao(){
        return this.duracao;
    }

    public void setFavorito(boolean favorito){
        this.favorito = favorito;
    }

    public boolean isFavorito(){
        return this.favorito;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    public void setEndereco_trailer1(String endereco_trailer1) {
        this.endereco_trailer1 = endereco_trailer1;
    }

    public String getEndereco_trailer1() {
        return endereco_trailer1;
    }

    public void setEndereco_trailer2(String endereco_trailer2) {
        this.endereco_trailer2 = endereco_trailer2;
    }


    public String getEndereco_trailer2() {
        return endereco_trailer2;
    }
}
