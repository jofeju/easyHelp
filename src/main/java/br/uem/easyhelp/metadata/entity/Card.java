package br.uem.easyhelp.metadata.entity;

import br.uem.easyhelp.metadata.type.CardSituationType;
import br.uem.easyhelp.metadata.type.CardType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "card")
public class Card implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "creation_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private CardType type;
    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private CardSituationType situation;
    @Column(length = 25, nullable = false)
    private String titulo;
    @Column(length = 150, nullable = false)
    private String descricao;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(nullable = true, name = "jogo_id")
    private Jogo jogo;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "jogador_id")
    private User jogador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public CardSituationType getSituation() {
        return situation;
    }

    public void setSituation(CardSituationType situation) {
        this.situation = situation;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public Person getJogador() {
        return jogador;
    }

    public void setJogador(User jogador) {
        this.jogador = jogador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card that = (Card) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(creationDate, that.creationDate) &&
                type == that.type &&
                situation == that.situation &&
                Objects.equals(titulo, that.titulo) &&
                Objects.equals(descricao, that.descricao) &&
                Objects.equals(jogo, that.jogo) &&
                Objects.equals(jogador, that.jogador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate, type, situation, titulo, descricao, jogo, jogador);
    }
}
