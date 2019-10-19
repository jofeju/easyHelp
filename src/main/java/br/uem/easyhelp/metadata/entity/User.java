package br.uem.easyhelp.metadata.entity;

import br.uem.easyhelp.metadata.type.UserType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User extends Person implements Serializable {

    @Column(length = 30, unique = true, nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    @Column(length = 50, nullable = false)
    private UserType type;
    @OneToMany(mappedBy = "jogador", cascade = CascadeType.ALL)
    private List<Card> cards;
    

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                type == user.type &&
                Objects.equals(cards, user.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), login, password, email, type, cards);
    }
}