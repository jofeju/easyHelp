/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.easyhelp.model;

import br.uem.easyhelp.dao.DeveloperDAO;
import br.uem.easyhelp.metadata.entity.Developer;
import br.uem.easyhelp.validator.DeveloperValidator;

/**
 *
 * @author Douglas
 */
public class DeveloperModel {
    private DeveloperDAO developerDAO;

    public DeveloperModel() {
        this.developerDAO = DeveloperDAO.getInstance();
    }

    public Developer insert(Developer developer) {

            DeveloperValidator developerValidator = new DeveloperValidator(developer);

            developerDAO.insert(developer);
            return developer;
    }

    public Developer update(Developer developer) {

            DeveloperValidator developerValidator = new DeveloperValidator(developer);
            developerDAO.update(developer);
            return developer;
    }
}
