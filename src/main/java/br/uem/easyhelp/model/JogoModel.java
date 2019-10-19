package br.uem.easyhelp.model;

import br.uem.easyhelp.dao.JogoDAO;
import br.uem.easyhelp.exceptions.ValidationException;
import br.uem.easyhelp.metadata.entity.Jogo;
import br.uem.easyhelp.util.FacesUtil;
import br.uem.easyhelp.validator.JogoValidator;

/**
 * @author Douglas
 */
public class JogoModel {
    private JogoDAO jogoDAO;

    public JogoModel() {
        this.jogoDAO = JogoDAO.getInstance();
    }

    public Jogo insert(Jogo jogo) {

            JogoValidator jogoValidator = new JogoValidator(jogo);

            jogoDAO.insert(jogo);
            return jogo;
    }

    public Jogo update(Jogo jogo) {

            JogoValidator jogoValidator = new JogoValidator(jogo);
            jogoDAO.update(jogo);
            return jogo;
    }
}
