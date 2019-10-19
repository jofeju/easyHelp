package br.uem.easyhelp.view;

import br.uem.easyhelp.controller.UserController;
import br.uem.easyhelp.metadata.entity.builder.UserBuilder;
import br.uem.easyhelp.util.FacesUtil;
import br.uem.easyhelp.web.session.SessionContext;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginView implements Serializable {
    private String login;
    private String password;

    private UserController userController;

    public LoginView() {
        userController = UserController.getInstance();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String signIn() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        userController.signIn(UserBuilder.anUser()
                .withLogin(login)
                .withPassword(password).build());
        if (SessionContext.getInstance().getLoggedUser() != null) {
            return FacesUtil.INDEX_FACE;
        }

        return "";
    }
}
