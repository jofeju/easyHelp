package br.uem.easyhelp.metadata.entity.builder;

import br.uem.easyhelp.metadata.entity.Jogo;
import br.uem.easyhelp.metadata.entity.Card;
import br.uem.easyhelp.metadata.entity.User;
import br.uem.easyhelp.metadata.type.CardSituationType;
import br.uem.easyhelp.metadata.type.CardType;

import java.util.Date;

/**
 * @author Douglas
 */
public final class CardBuilder {
    private Long id;
    private Date creationDate;
    private CardType type;
    private CardSituationType situation;
    private String titulo;
    private String descricao;
    private Jogo jogo;
    private User jogador;

    private CardBuilder() {
    }

    public static CardBuilder aCard() {
        return new CardBuilder();
    }

    public CardBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public CardBuilder withCreationDate(Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public CardBuilder withType(CardType type) {
        this.type = type;
        return this;
    }

    public CardBuilder withSituation(CardSituationType situation) {
        this.situation = situation;
        return this;
    }

    public CardBuilder withTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public CardBuilder withDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public CardBuilder withJogo(Jogo jogo) {
        this.jogo = jogo;
        return this;
    }

    public CardBuilder withJogador(User jogador) {
        this.jogador = jogador;
        return this;
    }

    public Card build() {
        Card card = new Card();
        card.setId(id);
        card.setCreationDate(creationDate);
        card.setType(type);
        card.setSituation(situation);
        card.setTitulo(titulo);
        card.setDescricao(descricao);
        card.setJogo(jogo);
        card.setJogador(jogador);
        return card;
    }
}
