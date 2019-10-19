package br.uem.easyhelp.view;

import br.uem.easyhelp.controller.CardController;
import br.uem.easyhelp.metadata.entity.Jogo;
import br.uem.easyhelp.metadata.entity.Card;
import br.uem.easyhelp.metadata.entity.Person;
import br.uem.easyhelp.metadata.entity.User;
import br.uem.easyhelp.metadata.entity.builder.CardBuilder;
import br.uem.easyhelp.metadata.type.CardSituationType;
import br.uem.easyhelp.metadata.type.CardType;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Douglas
 */
@Named
@SessionScoped
public class CardCreateView implements Serializable {
    private CardType type;
    private CardSituationType situation;
    private String titulo;
    private String descricao;
    private Jogo jogo;
    private User jogador;

    private boolean saveDisabled;

    private CardController cardController;

    private List<Jogo> jogos;
    private List<User> jogadores;

    public CardCreateView() {
        cardController = CardController.getInstance();
        saveDisabled = false;
        jogos = new ArrayList<>();
        jogadores = new ArrayList<>();
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public CardSituationType getSituation() {
        return situation;
    }

    public void setSituation(CardSituationType situation) {
        this.situation = situation;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public User getJogador() {
        return jogador;
    }

    public void setJogador(User jogador) {
        this.jogador = jogador;
    }

    public void setSaveDisabled(boolean saveDisabled) {
        this.saveDisabled = saveDisabled;
    }

    public boolean isSaveDisabled() {
        return saveDisabled;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }

    public List<User> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<User> jogadores) {
        this.jogadores = jogadores;
    }

    public void init() {
        saveDisabled = false;
        type = null;
        situation = null;
        titulo = null;
        descricao = null;
        jogo = null;
        jogador = null;
        jogos = findAllJogos();
        jogadores = findAllUsers();
    }

    public CardType[] getTypes() {
        return CardType.values();
    }

    public CardSituationType[] getSituationTypes() {
        return CardSituationType.values();
    }

    public List<Jogo> findAllJogos() {
        return cardController.getModel().findAllJogos();
    }

    public List<User> findAllUsers() {
        return cardController.getModel().findAllUsers();
    }

    public void save() {
        Card card = CardBuilder.aCard()
                .withJogo(jogo)
                .withCreationDate(new Date())
                .withDescricao(descricao)
                .withTitulo(titulo)
                .withSituation(situation)
                .withJogador(jogador)
                .withType(type)
                .build();

        if (cardController.insert(card)) {
            saveDisabled = true;

            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Card cadastrado com sucesso."));
        }
    }
}
