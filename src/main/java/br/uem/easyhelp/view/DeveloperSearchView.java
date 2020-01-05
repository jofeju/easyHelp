/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.easyhelp.view;

import br.uem.easyhelp.controller.DeveloperController;
import br.uem.easyhelp.exceptions.DeveloperException;
import br.uem.easyhelp.metadata.entity.Developer;
import br.uem.easyhelp.util.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class DeveloperSearchView implements Serializable {
    private Integer id;
    private String nome;
    private String desenvolvedor;

    private DeveloperController developerController;

    private Developer selectedDeveloper;
    private List<Developer> developers;

    public DeveloperSearchView() {
        developerController = DeveloperController.getInstance();
        developers = new ArrayList<>();
    }

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
    
    public String getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(String desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    public Developer getSelectedDeveloper() {
        return selectedDeveloper;
    }

    public void setSelectedDeveloper(Developer selectedDeveloper) {
        this.selectedDeveloper = selectedDeveloper;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    public void findDevelopers() {
        developers.clear();
        List<Developer> developers = null;
        try {
            if(id == null){
            developers = developerController.findByNomeId("", nome);
            }else{
            developers = developerController.findByNomeId(Integer.toString(id), nome);
            }
            this.developers = developers;
        } catch (DeveloperException e) {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", e.getMessage()));
            e.printStackTrace();
        }
    }

    public String createDeveloper() {
        return FacesUtil.DEV_CREATE_FACE;
    }

    public String editDeveloper() {
        if (selectedDeveloper != null) {
            return FacesUtil.DEV_EDIT_FACE + "?faces-redirect=true&id=" + selectedDeveloper.getId();
        }

        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Aviso!", "É necessário selecionar uma Empresa na tabela para essa ação."));

        return "";
    }

    public void deleteDeveloper() {
        Developer developer = selectedDeveloper;
        if (selectedDeveloper != null) {
            if (developerController.delete(selectedDeveloper)) {
                selectedDeveloper.setStatus(0);
                FacesContext.getCurrentInstance()
                        .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Sucesso!", "Empresa deletada com sucesso."));
            }
        } else {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Aviso!", "É necessário selecionar uma Empresa na tabela para essa ação."));
        }
    }
}
