package br.uem.easyhelp.model;

import br.uem.easyhelp.dao.UserDAO;
import br.uem.easyhelp.exceptions.UserException;
import br.uem.easyhelp.exceptions.ValidationException;
import br.uem.easyhelp.metadata.entity.User;
import br.uem.easyhelp.util.FacesUtil;
import br.uem.easyhelp.validator.UserValidator;
import br.uem.easyhelp.web.session.SessionContext;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Douglas
 */
public class UserModel {
    private UserDAO userDAO;

    private List<User> users;
    private User user;

    public UserModel() {
        this.userDAO = UserDAO.getInstance();
        this.users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void signIn(User user) {
        try {
            SessionContext.getInstance().setLoggedUser(userDAO.signIn(user));
        } catch (UserException e) {
            SessionContext.getInstance().setLoggedUser(null);
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", e.getMessage()));
            e.printStackTrace();
        }
    }

    public User insert(User user) {
        try {
            UserValidator userValidator = new UserValidator(user);

            if (!userValidator.validate()) {
                userValidator.getErrorMessages().forEach(message -> FacesUtil.displayError(message));
                throw new ValidationException("Usuário inválido");
            }

            userDAO.insert(user);
            return user;
        } catch (ValidationException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", e.getMessage()));
            e.printStackTrace();
            return null;
        }
    }

    public User update(User user) {
        try {
            UserValidator userValidator = new UserValidator(user);

            if (!userValidator.validate()) {
                userValidator.getErrorMessages().forEach(message -> FacesUtil.displayError(message));
                throw new ValidationException("Usuário inválido");
            }

            userDAO.update(user);
            return user;
        } catch (ValidationException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", e.getMessage()));
            e.printStackTrace();
            return null;
        }
    }
}
