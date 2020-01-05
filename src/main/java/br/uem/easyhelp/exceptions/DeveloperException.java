/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.easyhelp.exceptions;

/**
 *
 * @author Douglas
 */
public class DeveloperException extends Exception {
    public DeveloperException(Throwable cuase) {
        super(cuase);
    }

    public DeveloperException(String message) {
        super(message);
    }

    public DeveloperException(String message, Throwable cause) {
        super(message, cause);
    }
}