package br.uem.easyhelp.view;

import br.uem.easyhelp.controller.JogoController;
import br.uem.easyhelp.metadata.entity.Jogo;
import br.uem.easyhelp.metadata.entity.Card;
import br.uem.easyhelp.metadata.entity.Developer;
import br.uem.easyhelp.metadata.entity.builder.JogoBuilder;

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
public class JogoCreateView implements Serializable {
    private String nome;
    private List<Card> cards;
    private Integer id;
    private boolean saveDisabled;
    private boolean initEnabled;
    private Integer status;
    private Developer developer;
    
    private List<Developer> developers;

    private JogoController jogoController;

    public JogoCreateView() {
        jogoController = JogoController.getInstance();
        saveDisabled = false;
        initEnabled = true;
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

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> card) {
        this.cards = cards;
    }

    public boolean isSaveDisabled() {
        return saveDisabled;
    }

    public void setSaveDisabled(boolean saveDisabled) {
        this.saveDisabled = saveDisabled;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }
    
    public List<Developer> findAllDevelopers() {
        return jogoController.getModel().findAllDevelopers();
    }

    public void init() {
        if (initEnabled) {
            saveDisabled = false;
            nome = null;
            status = 1;
            developers = findAllDevelopers();
            developer = null;
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

        Jogo jogo = JogoBuilder.aJogo()
                .withId(id)
                .withNome(nome)
                .withStatus(status)
                .withDeveloper(developer)
                .build();

        if (jogoController.insert(jogo)) {
            saveDisabled = true;

            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Jogo cadastrado com sucesso."));

            initEnabled = true;
        }
    }

    public String cancel() {
        initEnabled = true;

        return "/restricted/jogo";
    }
}
