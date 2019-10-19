package br.uem.easyhelp.controller;

import br.uem.easyhelp.dao.JogoDAO;
import br.uem.easyhelp.exceptions.JogoException;
import br.uem.easyhelp.metadata.entity.Jogo;
import br.uem.easyhelp.model.JogoModel;

import java.io.Serializable;
import java.util.List;

/**
 * @author Douglas
 */
public class JogoController implements Serializable {
    private static JogoController ourInstance = new JogoController();

    public static JogoController getInstance() {
        return ourInstance;
    }

    private JogoModel model;
    private JogoDAO dao;

    private JogoController() {
        dao = JogoDAO.getInstance();
        model = new JogoModel();
    }

    public JogoModel getModel() {
        return model;
    }

    public boolean insert(Jogo jogo) {
        return model.insert(jogo) != null;
    }

    public boolean update(Jogo jogo) {
        return model.update(jogo) != null;
    }

    public boolean delete(Jogo jogo) {
        return dao.delete(jogo);
    }

    public Jogo findById(String id) throws JogoException {
        return dao.findById(id);
    }

    public List<Jogo> findByNomeId(String id, String nome) throws JogoException {
        return dao.findByNomeId(id, nome);
    }
}
