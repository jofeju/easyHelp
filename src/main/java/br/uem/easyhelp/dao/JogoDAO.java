package br.uem.easyhelp.dao;

import br.uem.easyhelp.exceptions.JogoException;
import br.uem.easyhelp.metadata.entity.Jogo;
import br.uem.easyhelp.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import java.util.List;

public class JogoDAO extends GenericDAO<Jogo> {
    private static JogoDAO ourInstance = new JogoDAO();

    public static JogoDAO getInstance() {
        return ourInstance;
    }

    private JogoDAO() {
        super(Jogo.class);
    }

    public Jogo findById(String id) throws JogoException {
        Jogo res = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            StringBuilder sql = new StringBuilder();
            sql.append("from Jogo c where c.id = '").append(id).append("'");
            Transaction transaction = session.beginTransaction();
            res = session.createQuery(sql.toString(), Jogo.class).getSingleResult();
        } catch (NoResultException ex) {
            throw new JogoException("Jogos com id: '" + id + "' não encontrado.", ex);
        } 

        return res;
    }

    public List<Jogo> findByNomeId(String id, String nome) throws JogoException {
        List<Jogo> res = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            StringBuilder sql = new StringBuilder();
            sql.append("from Jogo c where");
            if (id != null && !id.isEmpty()) {
                sql.append(" c.id = '").append(id).append("' and");
            }
            sql.append(" c.nome like '").append(nome).append("%'");
            res = session.createQuery(sql.toString(), Jogo.class).getResultList();
        } catch (NoResultException ex) {
            throw new JogoException("Nenhum jogo encontrado.", ex);
        } 

        return res;
    }
}
