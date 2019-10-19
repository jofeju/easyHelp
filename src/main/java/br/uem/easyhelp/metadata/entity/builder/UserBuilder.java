package br.uem.easyhelp.metadata.entity.builder;

import br.uem.easyhelp.metadata.entity.Card;
import br.uem.easyhelp.metadata.entity.User;
import br.uem.easyhelp.metadata.type.UserType;

import java.util.Date;
import java.util.List;

/**
 * @author Douglas
 */
public final class UserBuilder {
    private String login;
    private String cpf;
    private String password;
    private String firstName;
    private String email;
    private String lastName;
    private UserType type;
    private Date birthDate;
    private List<Card> cards;

    private UserBuilder() {
    }

    public static UserBuilder anUser() {
        return new UserBuilder();
    }

    public UserBuilder withLogin(String login) {
        this.login = login;
        return this;
    }

    public UserBuilder withCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder withType(UserType type) {
        this.type = type;
        return this;
    }

    public UserBuilder withBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public UserBuilder withCards(List<Card> cards) {
        this.cards = cards;
        return this;
    }

    public User build() {
        User user = new User();
        user.setLogin(login);
        user.setCpf(cpf);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setEmail(email);
        user.setLastName(lastName);
        user.setType(type);
        user.setBirthDate(birthDate);
        user.setCards(cards);
        return user;
    }
}
