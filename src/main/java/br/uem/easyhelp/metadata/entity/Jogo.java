package br.uem.easyhelp.metadata.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "jogo")
public class Jogo implements Serializable {

    @Id
    @Column(length = 5, unique = true, nullable = false)
    private String id;
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 50, nullable = false)
    private String desenvolvedor;
    @OneToMany(mappedBy = "jogo", cascade = CascadeType.ALL)
    private List<Card> cards;

   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(String desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }
    
    public String getDisplayName() {
        return nome;// + " (" + desenvolvedor+")";
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
        Jogo jogo = (Jogo) o;
        return Objects.equals(id, jogo.id) &&
                Objects.equals(nome, jogo.nome) &&
                Objects.equals(desenvolvedor, jogo.desenvolvedor) &&
                Objects.equals(cards, jogo.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, nome, desenvolvedor, cards);
    }
}