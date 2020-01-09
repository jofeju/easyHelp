/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.easyhelp.view;

import br.uem.easyhelp.controller.DeveloperController;
import br.uem.easyhelp.metadata.entity.Developer;
import br.uem.easyhelp.metadata.entity.builder.DeveloperBuilder;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Douglas
 */
@Named
@SessionScoped
public class DeveloperCreateView implements Serializable{
    private Integer id;
    private String nome;
    private String cidade;
    private String pais;
    private String email;
    private Long telefone;
    private Integer status;
    
    private boolean saveDisabled;
    private boolean initEnabled;

    private DeveloperController developerController;

    public DeveloperCreateView() {
        developerController = DeveloperController.getInstance();
        saveDisabled = false;
        initEnabled = true;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public boolean isSaveDisabled() {
        return saveDisabled;
    }

    public void setSaveDisabled(boolean saveDisabled) {
        this.saveDisabled = saveDisabled;
    }

    public void init() {
        if (initEnabled) {
            saveDisabled = false;
            nome = null;
            cidade = null;
            pais = null;
            email = null;
            telefone = null;
            status = 1;
        }
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public void save() {
        initEnabled = false;

        Developer developer = DeveloperBuilder.aDeveloper()
                .withId(id)
                .withNome(nome)
                .withCidade(cidade)
                .withPais(pais)
                .withEmail(email)
                .withTelefone(telefone)
                .withStatus(status)
                .build();

        if (developerController.insert(developer)) {
            saveDisabled = true;

            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Empresa cadastrada com sucesso."));

            initEnabled = true;
        }
    }

    public String cancel() {
        initEnabled = true;

        return "/restricted/dev";
    }
}
