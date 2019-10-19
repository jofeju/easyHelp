package br.uem.easyhelp.model;

import br.uem.easyhelp.dao.JogoDAO;
import br.uem.easyhelp.dao.CardDAO;
import br.uem.easyhelp.dao.UserDAO;
import br.uem.easyhelp.metadata.entity.Jogo;
import br.uem.easyhelp.metadata.entity.Card;
import br.uem.easyhelp.metadata.entity.User;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Douglas
 */
public class CardModel {
    private CardDAO dao;

    private List<Card> cards;
    private Card card;

    private JogoDAO jogoDAO;
    private UserModel userModel;
    private UserDAO userDAO;

    public CardModel() {
        this.dao = CardDAO.getInstance();
        this.cards = new ArrayList<>();
        this.jogoDAO = JogoDAO.getInstance();
        this.userModel = new UserModel();
        this.userDAO = UserDAO.getInstance();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Card> findCardsByUserAndJogoCriteria(String cpfJogador,
                                                                       String idJogo) {
        try {
            if ((cpfJogador != null && !cpfJogador.isEmpty())
                    || (idJogo != null && idJogo.isEmpty())) {
                return dao.findCardsByUserAndJogoCriteria(cpfJogador, idJogo);
            }
            return dao.listAll();
        } catch (Exception e) {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", e.getMessage()));
            return null;
        }
    }
    
    public List<Jogo> findAllJogos() {
        return jogoDAO.listAll();
    }

    public List<User> findAllUsers() {
        return userDAO.listAll();
    }

    public Card findById(Long id) {
        return dao.findById(id);
    }

    public Card insert(Card card) {
        try {
            dao.insert(card);
            return card;
        } catch (Exception e) {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", e.getMessage()));
            return null;
        }
    }

    public Card update(Card card) {
        try {
            dao.update(card);
            return card;
        } catch (Exception e) {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", e.getMessage()));
            return null;
        }
    }

}
