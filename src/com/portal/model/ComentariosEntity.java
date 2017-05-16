package com.portal.model;

import javax.persistence.*;

/**
 * Created by italo on 15/05/17.
 */
@Entity
@Table(name = "comentarios", schema = "portal", catalog = "")
public class ComentariosEntity {
    private int id;
    private String titulo;
    private String conteudo;
    private String dataCriacao;
    private Integer postagemId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "titulo")
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Basic
    @Column(name = "conteudo")
    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Basic
    @Column(name = "data_criacao")
    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Basic
    @Column(name = "postagem_id")
    public Integer getPostagemId() {
        return postagemId;
    }

    public void setPostagemId(Integer postagemId) {
        this.postagemId = postagemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComentariosEntity that = (ComentariosEntity) o;

        if (id != that.id) return false;
        if (titulo != null ? !titulo.equals(that.titulo) : that.titulo != null) return false;
        if (conteudo != null ? !conteudo.equals(that.conteudo) : that.conteudo != null) return false;
        if (dataCriacao != null ? !dataCriacao.equals(that.dataCriacao) : that.dataCriacao != null) return false;
        if (postagemId != null ? !postagemId.equals(that.postagemId) : that.postagemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (conteudo != null ? conteudo.hashCode() : 0);
        result = 31 * result + (dataCriacao != null ? dataCriacao.hashCode() : 0);
        result = 31 * result + (postagemId != null ? postagemId.hashCode() : 0);
        return result;
    }
}
