package br.uem.easyhelp.view;

import br.uem.easyhelp.controller.UserController;
import br.uem.easyhelp.metadata.entity.Card;
import br.uem.easyhelp.metadata.entity.User;
import br.uem.easyhelp.metadata.entity.builder.UserBuilder;
import br.uem.easyhelp.metadata.type.UserType;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Douglas
 */
@Named
@SessionScoped
public class UserCreateView implements Serializable {
    private String login;
    private String cpf;
    private String password;
    private String firstName;
    private String email;
    private String lastName;
    private UserType type;
    private Date birthDate;
    private List<Card> cards;

    private boolean saveDisabled;
    private boolean initEnabled;

    private UserController userController;

    public UserCreateView() {
        userController = UserController.getInstance();
        saveDisabled = false;
        initEnabled = false;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public boolean isSaveDisabled() {
        return saveDisabled;
    }

    public void init() {
        if (initEnabled) {
            saveDisabled = false;
            login = null;
            cpf = null;
            password = null;
            firstName = null;
            email = null;
            lastName = null;
            type = null;
            birthDate = null;
            cards = null;
        }
    }

    public UserType[] getTypes() {
        return UserType.values();
    }

    public void save() {
        initEnabled = false;

        User user = UserBuilder.anUser()
                .withLogin(login)
                .withPassword(password)
                .withBirthDate(birthDate)
                .withCpf(cpf)
                .withEmail(email)
                .withFirstName(firstName)
                .withLastName(lastName)
                .withType(type).build();

        if (userController.insert(user)) {
            saveDisabled = true;

            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Usuário cadastrado com sucesso."));

            initEnabled = true;
        }
    }

    public String cancel() {
        initEnabled = true;

        return "/restricted/user";
    }
}
