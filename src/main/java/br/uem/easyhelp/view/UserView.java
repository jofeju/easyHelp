package br.uem.easyhelp.view;

import br.uem.easyhelp.controller.UserController;
import br.uem.easyhelp.exceptions.UserException;
import br.uem.easyhelp.metadata.entity.User;
import br.uem.easyhelp.util.FacesUtil;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Douglas
 */
@Named
@SessionScoped
public class UserView implements Serializable {
    private String cpf;
    private String firstName;

    private User selectedUser;
    private List<User> users;

    private UserController userController;

    public UserView() {
        userController = UserController.getInstance();
        users = new ArrayList<>();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void findUserByCpf() {
        users.clear();
        User user = null;

        try {
            user = userController.findByCpf(cpf);

            if (user != null) {
                users.add(user);
            }
        } catch (UserException e) {
            FacesUtil.displayError(e.getMessage());
            e.printStackTrace();
        }
    }

    public void findUsersWhereFirstNameLike() {
        users.clear();
        List<User> users = null;
        try {
            users = userController.findUsersWhereFirstNameLike(firstName);
            if (users != null) {
                this.users = users;
            }
        } catch (UserException e) {
            e.printStackTrace();
        }
    }

    public void findUsers() {
        users.clear();
        List<User> users = null;
        try {
            users = userController.findByCpfAndWhereFirstNameLike(cpf, firstName);
            if (users != null) {
                this.users = users;
            }
        } catch (UserException e) {
            e.printStackTrace();
        }
    }

    public String createUser() {
        return FacesUtil.USER_CREATE_FACE;
    }

    public String editUser() {
        if (selectedUser != null) {
            return FacesUtil.USER_EDIT_FACE + "?faces-redirect=true&cpf=" + selectedUser.getCpf();
        }

        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Aviso!", "É necessário selecionar um Usuário na tabela para essa ação."));

        return "";
    }

    public void deleteUser() {
        User user = selectedUser;
        if (selectedUser != null) {
            if (userController.delete(selectedUser)) {
                users.remove(user);
                FacesContext.getCurrentInstance()
                        .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Sucesso!", "Usuário deletado com sucesso."));
            }
        } else {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Aviso!", "É necessário selecionar um Usuário na tabela para essa ação."));
        }
    }
}
