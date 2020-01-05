/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.easyhelp.validator;

import br.uem.easyhelp.metadata.entity.Developer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Douglas
 */
public class DeveloperValidator {
    private Developer developer;
    private List<String> errorMessages;

    public DeveloperValidator(Developer developer) {
        this.developer = developer;
        errorMessages = new ArrayList<>();
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }
}
