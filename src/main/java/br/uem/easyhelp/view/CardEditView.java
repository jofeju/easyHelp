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
import java.util.Map;

/**
 * @author Douglas
 */
@Named
@SessionScoped
public class CardEditView implements Serializable {
    private Long id;
    private Date creationDate;
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

    public CardEditView() {
        cardController = CardController.getInstance();
        saveDisabled = false;
        jogos = new ArrayList<>();
        jogadores = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Person getJogador() {
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
        Map<String, String> params =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String cardId = params.get("id");
        if (cardId != null && !cardId.isEmpty()) {
            Card card = cardController.getModel().findById(Long.valueOf(cardId));

            jogos = findAllJogos();
            jogadores = findAllPlayers();

            saveDisabled = false;
            id = card.getId();
            creationDate = card.getCreationDate();
            type = card.getType();
            situation = card.getSituation();
            titulo = card.getTitulo();
            descricao = card.getDescricao();
            jogo = card.getJogo();
            jogador = jogadores.stream()
                    .filter(t -> t.getCpf().equals(card.getJogador().getCpf())).findFirst().orElse(null);
        }
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

    public List<User> findAllPlayers() {
        return cardController.getModel().findAllUsers();
    }

    public void save() {
        Card card = CardBuilder.aCard()
                .withJogo(jogo)
                .withDescricao(descricao)
                .withTitulo(titulo)
                .withSituation(situation)
                .withJogador(jogador)
                .withType(type)
                .withId(id)
                .withCreationDate(creationDate)
                .build();

        if (cardController.update(card)) {
            saveDisabled = true;

            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Card atualizado com sucesso."));
        }
    }
}
