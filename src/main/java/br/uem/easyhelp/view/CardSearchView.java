package br.uem.easyhelp.view;

import br.uem.easyhelp.controller.CardController;
import br.uem.easyhelp.metadata.entity.Card;
import br.uem.easyhelp.util.FacesUtil;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Douglas
 */
@Named
@SessionScoped
public class CardSearchView implements Serializable {
    private String cpfJogador;
    private String idJogo;
    private String idCard;

    private List<Card> cards;
    private Card selectedCard;

    private CardController cardController;

    public CardSearchView() {
        cardController = CardController.getInstance();
        cards = new ArrayList<>();
    }

    public String getCpfJogador() {
        return cpfJogador;
    }

    public void setCpfJogador(String cpfJogador) {
        this.cpfJogador = cpfJogador;
    }

    public String getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(String idJogo) {
        this.idJogo = idJogo;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Card getSelectedCard() {
        return selectedCard;
    }

    public void setSelectedCard(Card selectedCard) {
        this.selectedCard = selectedCard;
    }

    public void findCards() {
        this.cards.clear();
        List<Card> cards = cardController.getModel()
                .findCardsByUserAndJogoCriteria(cpfJogador, idJogo);
        if (cards != null) {
            this.cards = cards;
        }
    }

    public String editCard() {
        return FacesUtil.CARD_EDIT_FACE + "?faces-redirect=true&id=" + selectedCard.getId();
    }
}
