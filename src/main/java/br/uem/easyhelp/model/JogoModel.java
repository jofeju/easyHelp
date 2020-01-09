package br.uem.easyhelp.model;

import br.uem.easyhelp.dao.DeveloperDAO;
import br.uem.easyhelp.dao.JogoDAO;
import br.uem.easyhelp.exceptions.ValidationException;
import br.uem.easyhelp.metadata.entity.Developer;
import br.uem.easyhelp.metadata.entity.Jogo;
import br.uem.easyhelp.util.FacesUtil;
import br.uem.easyhelp.validator.JogoValidator;
import java.util.List;

/**
 * @author Douglas
 */
public class JogoModel {
    private JogoDAO jogoDAO;
    private DeveloperDAO developerDAO;

    public JogoModel() {
        this.jogoDAO = JogoDAO.getInstance();
        this.developerDAO = DeveloperDAO.getInstance();
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
    
    public List<Developer> findAllDevelopers() {
        return developerDAO.listAll();
    }
}
