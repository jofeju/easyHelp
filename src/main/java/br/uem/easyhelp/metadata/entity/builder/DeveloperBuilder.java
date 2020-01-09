/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.easyhelp.metadata.entity.builder;

import br.uem.easyhelp.metadata.entity.Developer;

/**
 *
 * @author Douglas
 */
public final class DeveloperBuilder {
    private Integer id;
    private String nome;
    private String cidade;
    private String pais;
    private String email;
    private Long telefone;
    private Integer status;

    private DeveloperBuilder() {
    }

    public static DeveloperBuilder aDeveloper() {
        return new DeveloperBuilder();
    }

    public DeveloperBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public DeveloperBuilder withNome(String nome) {
        this.nome = nome;
        return this;
    }
    
    public DeveloperBuilder withCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }
    
    public DeveloperBuilder withPais(String pais) {
        this.pais = pais;
        return this;
    }

    public DeveloperBuilder withEmail(String email) {
        this.email = email;
        return this;
    }
    
    public DeveloperBuilder withStatus(Integer status) {
        this.status = status;
        return this;
    }
    
    public DeveloperBuilder withTelefone(Long telefone) {
        this.telefone = telefone;
        return this;
    }
    

    public Developer build() {
        Developer developer = new Developer();
        developer.setId(id);
        developer.setNome(nome);
        developer.setCidade(cidade);
        developer.setPais(pais);
        developer.setEmail(email);
        developer.setTelefone(telefone);
        developer.setStatus(status);
        return developer;
    }
}