package br.uem.easyhelp.controller;

import br.uem.easyhelp.dao.UserDAO;
import br.uem.easyhelp.exceptions.UserException;
import br.uem.easyhelp.metadata.entity.User;
import br.uem.easyhelp.model.UserModel;

import java.io.Serializable;
import java.util.List;

/**
 * @author Douglas
 */
public class UserController implements Serializable {
    private static UserController ourInstance = new UserController();

    public static UserController getInstance() {
        return ourInstance;
    }

    private UserModel model;
    private UserDAO dao;

    private UserController() {
        model = new UserModel();
        dao = UserDAO.getInstance();
    }

    public UserModel getModel() {
        return model;
    }

    public void signIn(User user) {
        model.signIn(user);
    }

    public User findByCpf(String cpf) throws UserException {
        return dao.findByCpf(cpf);
    }

    public List<User> findUsersWhereFirstNameLike(String firstName) throws UserException {
        return dao.findWhereFirstNameLike(firstName);
    }

    public List<User> findByCpfAndWhereFirstNameLike(String cpf, String firstName) throws UserException {
        return dao.findByCpfAndWhereFirstNameLike(cpf, firstName);
    }

    public List<User> findAll() {
        return dao.listAll();
    }

    public boolean insert(User user) {
        return model.insert(user) != null;
    }

    public boolean update(User user) {
        return model.update(user) != null;
    }

    public boolean delete(User user) {
        return dao.delete(user);
    }
}
