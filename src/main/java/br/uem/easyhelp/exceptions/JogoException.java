package br.uem.easyhelp.exceptions;

/**
 * @author Douglas
 */
public class JogoException extends Exception {
    public JogoException(Throwable cuase) {
        super(cuase);
    }

    public JogoException(String message) {
        super(message);
    }

    public JogoException(String message, Throwable cause) {
        super(message, cause);
    }
}
