package br.uem.easyhelp.controller;

import br.uem.easyhelp.metadata.entity.Card;
import br.uem.easyhelp.model.CardModel;

import java.io.Serializable;

/**
 * @author Douglas
 */
public class CardController implements Serializable {
    private static CardController ourInstance = new CardController();

    public static CardController getInstance() {
        return ourInstance;
    }

    private CardModel model;

    private CardController() {
        model = new CardModel();
    }

    public CardModel getModel() {
        return model;
    }

    public boolean insert(Card card) {
        return model.insert(card) != null;
    }

    public boolean update(Card card) {
        return model.update(card) != null;
    }
}
