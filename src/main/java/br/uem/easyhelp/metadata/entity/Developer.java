/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.easyhelp.metadata.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Douglas
 */
@Entity
@Table(name = "developer")
public class Developer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 5, unique = true, nullable = false)
    private Integer id;
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 50, nullable = false)
    private String cidade;
    @Column(length = 50, nullable = false)
    private String pais;
    @Column(length = 50, nullable = false)
    private String email;
    @Column(length = 20, nullable = false)
    private Long telefone;
    @Column (nullable = false)
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

   
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public String getDisplayName() {
        return nome;// + " (" + desenvolvedor+")";
    }
    
        
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Developer developer = (Developer) o;
        return Objects.equals(id, developer.id) &&
                Objects.equals(nome, developer.nome) &&
                Objects.equals(cidade, developer.cidade) &&
                Objects.equals(pais, developer.pais) &&
                Objects.equals(email, developer.email) &&
                Objects.equals(telefone, developer.telefone) &&
                Objects.equals(status, developer.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, nome, cidade, pais, email, telefone, status);
    }
}