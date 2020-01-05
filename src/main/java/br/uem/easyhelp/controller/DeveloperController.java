/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.easyhelp.controller;

import br.uem.easyhelp.dao.DeveloperDAO;
import br.uem.easyhelp.exceptions.DeveloperException;
import br.uem.easyhelp.metadata.entity.Developer;
import br.uem.easyhelp.model.DeveloperModel;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Douglas
 */
public class DeveloperController implements Serializable {
    private static DeveloperController ourInstance = new DeveloperController();

    public static DeveloperController getInstance() {
        return ourInstance;
    }

    private DeveloperModel model;
    private DeveloperDAO dao;

    private DeveloperController() {
        dao = DeveloperDAO.getInstance();
        model = new DeveloperModel();
    }

    public DeveloperModel getModel() {
        return model;
    }

    public boolean insert(Developer jogo) {
        return model.insert(jogo) != null;
    }

    public boolean update(Developer jogo) {
        return model.update(jogo) != null;
    }

    public boolean delete(Developer jogo) {
        jogo.setStatus(0);
        return dao.delete(jogo);
    }

    public Developer findById(String id) throws DeveloperException {
        return dao.findById(id);
    }

    public List<Developer> findByNomeId(String id, String nome) throws DeveloperException {
        return dao.findByNomeId(id, nome);
    }
}

