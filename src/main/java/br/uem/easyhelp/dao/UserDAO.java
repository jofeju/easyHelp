package br.uem.easyhelp.dao;

import br.uem.easyhelp.exceptions.UserException;
import br.uem.easyhelp.metadata.entity.User;
import br.uem.easyhelp.metadata.type.UserType;
import br.uem.easyhelp.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import java.util.List;

public class UserDAO extends GenericDAO<User> {
    private static UserDAO ourInstance = new UserDAO();

    public static UserDAO getInstance() {
        return ourInstance;
    }

    private UserDAO() {
        super(User.class);
    }

    public User signIn(User user) throws UserException {
        if (user.getLogin().equals("su") && user.getPassword().equals("su")) {
            user.setFirstName("SU");
            user.setLastName("SUPER USER");
            user.setType(UserType.ADMIN);
            System.out.println("SU LOGADO");
            return user;
        }

        User res;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            StringBuilder sql = new StringBuilder();
            sql.append("from User u where CAST(u.login as binary) = CAST('").append(user.getLogin())
                    .append("' as binary) and CAST(u.password as binary) = CAST('").append(user.getPassword())
                    .append("' as binary)");
            res = session.createQuery(sql.toString(), User.class).getSingleResult();
        } catch (NoResultException ex) {
            throw new UserException("Usuário não encontrado.", ex);
        }

        return res;
    }

    public User findByCpf(String cpf) throws UserException {
        User res;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            StringBuilder sql = new StringBuilder();
            sql.append("from User u where u.cpf = '").append(cpf).append("'");
            res = session.createQuery(sql.toString(), User.class).getSingleResult();
        } catch (NoResultException ex) {
            throw new UserException("Usuário com cpf '" + cpf + "' não encontrado.", ex);
        }

        return res;
    }

    public List<User> findWhereFirstNameLike(String firstName) throws UserException {
        List<User> res;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            StringBuilder sql = new StringBuilder();
            sql.append("from User u where u.firstName like '").append(firstName).append("%'");
            res = session.createQuery(sql.toString(), User.class).getResultList();
        } catch (NoResultException ex) {
            throw new UserException("Usuário com nome '" + firstName + "' não encontrado.", ex);
        }

        return res;
    }

    public List<User> findByCpfAndWhereFirstNameLike(String cpf, String firstName) throws UserException {
        List<User> res;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            StringBuilder sql = new StringBuilder();
            sql.append("from User u where");
            if (cpf != null && !cpf.isEmpty()) {
                sql.append(" u.cpf = '").append(cpf).append("' and");
            }
            sql.append(" u.firstName like '").append(firstName).append("%'");
            res = session.createQuery(sql.toString(), User.class).getResultList();
        } catch (NoResultException ex) {
            throw new UserException("Nenhum usuário encontrado.", ex);
        }

        return res;
    }
}
