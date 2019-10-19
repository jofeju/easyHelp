package br.uem.easyhelp.view;

import br.uem.easyhelp.controller.JogoController;
import br.uem.easyhelp.exceptions.JogoException;
import br.uem.easyhelp.metadata.entity.Jogo;
import br.uem.easyhelp.metadata.entity.Card;
import br.uem.easyhelp.metadata.entity.builder.JogoBuilder;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author Douglas
 */
@Named
@SessionScoped
public class JogoEditView implements Serializable {
    private String id;
    private String nome;
    private String desenvolvedor;
    private List<Card> cards;

    private boolean saveDisabled;
    private boolean initEnabled;

    private JogoController jogoController;

    public JogoEditView() {
        jogoController = JogoController.getInstance();
        saveDisabled = false;
        initEnabled = true;
    }

    public void init() {
        if (initEnabled) {
            Map<String, String> params =
                    FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
            String jogoId = params.get("id");
            if (jogoId != null && !jogoId.isEmpty()) {
                Jogo jogo = null;
                try {
                    jogo = jogoController.findById(jogoId);

                    saveDisabled = false;
                    id = jogo.getId();
                    nome = jogo.getNome();
                    desenvolvedor = jogo.getDesenvolvedor();
                } catch (JogoException e) {
                    FacesContext.getCurrentInstance()
                            .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", e.getMessage()));
                    
                }
            }
        }
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

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public boolean isSaveDisabled() {
        return saveDisabled;
    }

    public void setSaveDisabled(boolean saveDisabled) {
        this.saveDisabled = saveDisabled;
    }

    public void save() {
        initEnabled = false;

        Jogo jogo = JogoBuilder.aJogo()
                .withId(id)
                .withNome(nome)
                .withDesenvolvedor(desenvolvedor)
                .build();

        if (jogoController.update(jogo)) {
            saveDisabled = true;

            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Jogo atualizado com sucesso."));

            initEnabled = true;
        }
    }

    public String cancel() {
        initEnabled = true;

        return "/restricted/jogo?faces-redirect=true";
    }
}
