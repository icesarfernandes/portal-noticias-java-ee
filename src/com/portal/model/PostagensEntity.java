package com.portal.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by italo on 15/05/17.
 */
@Entity
@Table(name = "postagens", schema = "portal", catalog = "")
public class PostagensEntity {
    private int id;
    private String titulo;
    private String conteudo;
    private Timestamp dataCriacao;
    private Integer userId;
    private Integer categoriaId;

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
    public Timestamp getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Timestamp dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "categoria_id")
    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostagensEntity that = (PostagensEntity) o;

        if (id != that.id) return false;
        if (titulo != null ? !titulo.equals(that.titulo) : that.titulo != null) return false;
        if (conteudo != null ? !conteudo.equals(that.conteudo) : that.conteudo != null) return false;
        if (dataCriacao != null ? !dataCriacao.equals(that.dataCriacao) : that.dataCriacao != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (categoriaId != null ? !categoriaId.equals(that.categoriaId) : that.categoriaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (conteudo != null ? conteudo.hashCode() : 0);
        result = 31 * result + (dataCriacao != null ? dataCriacao.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (categoriaId != null ? categoriaId.hashCode() : 0);
        return result;
    }
}
