/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.easyhelp.dao;

import br.uem.easyhelp.exceptions.DeveloperException;
import br.uem.easyhelp.metadata.entity.Developer;
import br.uem.easyhelp.util.HibernateUtil;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Douglas
 */
public class DeveloperDAO extends GenericDAO<Developer> {
    private static DeveloperDAO ourInstance = new DeveloperDAO();

    public static DeveloperDAO getInstance() {
        return ourInstance;
    }

    private DeveloperDAO() {
        super(Developer.class);
    }

    public Developer findById(String id) throws DeveloperException {
        Developer res = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            StringBuilder sql = new StringBuilder();
            sql.append("from Developer c where c.id = '").append(id).append("'");
            Transaction transaction = session.beginTransaction();
            res = session.createQuery(sql.toString(), Developer.class).getSingleResult();
        } catch (NoResultException ex) {
            throw new DeveloperException("Empresa com id: '" + id + "' não encontrada.", ex);
        } 

        return res;
    }

    public List<Developer> findByNomeId(String id, String nome) throws DeveloperException {
        List<Developer> res = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            StringBuilder sql = new StringBuilder();
            sql.append("from Developer c where c.status = 1 and");
            if (id != null) {
                sql.append(" c.id = '").append(id).append("' and");
            }
            sql.append(" c.nome like '").append(nome).append("%'");
            res = session.createQuery(sql.toString(), Developer.class).getResultList();
        } catch (NoResultException ex) {
            throw new DeveloperException("Nenhuma empresa encontrada.", ex);
        } 

        return res;
    }
}

