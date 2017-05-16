package com.portal.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by italo on 15/05/17.
 */
@Entity
@Table(name = "users", schema = "portal")
public class UsersEntity {
    private int id;
    private String usuario;
    private String senha;
    private Date dataCriacao;
    private String permissao;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "usuario")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Basic
    @Column(name = "senha")
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Basic
    @Column(name = "data_criacao")
    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Basic
    @Column(name = "permissao")
    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != that.id) return false;
        if (usuario != null ? !usuario.equals(that.usuario) : that.usuario != null) return false;
        if (senha != null ? !senha.equals(that.senha) : that.senha != null) return false;
        if (dataCriacao != null ? !dataCriacao.equals(that.dataCriacao) : that.dataCriacao != null) return false;
        if (permissao != null ? !permissao.equals(that.permissao) : that.permissao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + (senha != null ? senha.hashCode() : 0);
        result = 31 * result + (dataCriacao != null ? dataCriacao.hashCode() : 0);
        result = 31 * result + (permissao != null ? permissao.hashCode() : 0);
        return result;
    }
}
