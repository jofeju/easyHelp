package br.uem.easyhelp.metadata.entity.builder;

import br.uem.easyhelp.metadata.entity.Jogo;
import br.uem.easyhelp.metadata.entity.Card;

import java.util.List;

/**
 * @author Douglas
 */
public final class JogoBuilder {
    private String id;
    private String nome;
    private String desenvolvedor;

    private JogoBuilder() {
    }

    public static JogoBuilder aJogo() {
        return new JogoBuilder();
    }

    public JogoBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public JogoBuilder withNome(String nome) {
        this.nome = nome;
        return this;
    }

    public JogoBuilder withDesenvolvedor(String desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
        return this;
    }

    public Jogo build() {
        Jogo jogo = new Jogo();
        jogo.setId(id);
        jogo.setNome(nome);
        jogo.setDesenvolvedor(desenvolvedor);
        return jogo;
    }
}
