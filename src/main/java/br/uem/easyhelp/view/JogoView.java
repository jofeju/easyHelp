package br.uem.easyhelp.view;

import br.uem.easyhelp.controller.JogoController;
import br.uem.easyhelp.exceptions.JogoException;
import br.uem.easyhelp.metadata.entity.Jogo;
import br.uem.easyhelp.util.FacesUtil;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Douglas
 */
@Named
@SessionScoped
public class JogoView implements Serializable {
    private String id;
    private String nome;
    private String desenvolvedor;

    private JogoController jogoController;

    private Jogo selectedJogo;
    private List<Jogo> jogos;

    public JogoView() {
        jogoController = JogoController.getInstance();
        jogos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Jogo getSelectedJogo() {
        return selectedJogo;
    }

    public void setSelectedJogo(Jogo selectedJogo) {
        this.selectedJogo = selectedJogo;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }

    public void findJogos() {
        jogos.clear();
        List<Jogo> jogos = null;
        try {
            jogos = jogoController.findByNomeId(id, nome);
            this.jogos = jogos;
        } catch (JogoException e) {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", e.getMessage()));
            e.printStackTrace();
        }
    }

    public String createJogo() {
        return FacesUtil.JOGO_CREATE_FACE;
    }

    public String editJogo() {
        if (selectedJogo != null) {
            return FacesUtil.JOGO_EDIT_FACE + "?faces-redirect=true&id=" + selectedJogo.getId();
        }

        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Aviso!", "É necessário selecionar um Cliente na tabela para essa ação."));

        return "";
    }

    public void deleteJogo() {
        Jogo jogo = selectedJogo;
        if (selectedJogo != null) {
            if (jogoController.delete(selectedJogo)) {
                jogos.remove(jogo);
                FacesContext.getCurrentInstance()
                        .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Sucesso!", "Jogo deletado com sucesso."));
            }
        } else {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Aviso!", "É necessário selecionar um Jogo na tabela para essa ação."));
        }
    }
}
