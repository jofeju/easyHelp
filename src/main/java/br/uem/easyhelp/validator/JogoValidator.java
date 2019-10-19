package br.uem.easyhelp.validator;

import br.uem.easyhelp.metadata.entity.Jogo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Douglas
 */
public class JogoValidator {

    private Jogo jogo;
    private List<String> errorMessages;

    public JogoValidator(Jogo jogo) {
        this.jogo = jogo;
        errorMessages = new ArrayList<>();
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    
}
