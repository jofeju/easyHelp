package br.uem.easyhelp.dao;

import br.uem.easyhelp.exceptions.CardException;
import br.uem.easyhelp.metadata.entity.Card;
import br.uem.easyhelp.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import java.util.List;

public class CardDAO extends GenericDAO<Card> {
    private static CardDAO ourInstance = new CardDAO();

    public static CardDAO getInstance() {
        return ourInstance;
    }

    private CardDAO() {
        super(Card.class);
    }

    public List<Card> findCardsByUserAndJogoCriteria(String cpfJogador,
                                                                       String idJogo) throws CardException {
        List<Card> res;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            StringBuilder sql = new StringBuilder();
            sql.append("select sor from Card sor")
                    .append(" inner join sor.jogo jg")
                    .append(" where");
            if (idJogo != null && !idJogo.isEmpty()) {
                sql.append("jg.id = '").append(idJogo).append("'");
            }
            res = session.createQuery(sql.toString(), Card.class).getResultList();
        } catch (NoResultException ex) {
            throw new CardException("Nenhum card encontrado.", ex);
        }

        return res;
    }
}
