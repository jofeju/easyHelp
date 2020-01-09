package br.uem.easyhelp.metadata.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "jogo")
public class Jogo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 5, unique = true, nullable = false)
    private Integer id;
    @Column(length = 50, nullable = false)
    private String nome;
    @OneToMany(mappedBy = "jogo", cascade = CascadeType.ALL)
    private List<Card> cards;
    @Column (nullable = false)
    private Integer status;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "developer_id")
    private Developer developer;

   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDisplayName() {
        return nome;// + " (" + desenvolvedor+")";
    }
    
    public String getDisplayDevName() {
        return developer.getNome();
    }
    
    
    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }
      
        
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Jogo jogo = (Jogo) o;
        return Objects.equals(id, jogo.id) &&
                Objects.equals(nome, jogo.nome) &&
                Objects.equals(cards, jogo.cards) &&
                Objects.equals(status, jogo.status) &&
                Objects.equals(developer, jogo.developer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, nome, cards, status, developer);
    }
}