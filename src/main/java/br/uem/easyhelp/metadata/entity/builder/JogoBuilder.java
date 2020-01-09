package br.uem.easyhelp.metadata.entity.builder;

import br.uem.easyhelp.metadata.entity.Developer;
import br.uem.easyhelp.metadata.entity.Jogo;

/**
 * @author Douglas
 */
public final class JogoBuilder {
    private Integer id;
    private String nome;
    private Integer status;
    private Developer developer;

    private JogoBuilder() {
    }

    public static JogoBuilder aJogo() {
        return new JogoBuilder();
    }

    public JogoBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public JogoBuilder withNome(String nome) {
        this.nome = nome;
        return this;
    }

    public JogoBuilder withStatus(Integer status) {
        this.status = status;
        return this;
    }
    
    public JogoBuilder withDeveloper(Developer developer) {
        this.developer = developer;
        return this;
    }

    public Jogo build() {
        Jogo jogo = new Jogo();
        jogo.setId(id);
        jogo.setNome(nome);
        jogo.setDeveloper(developer);
        jogo.setStatus(status);
        return jogo;
    }
}
