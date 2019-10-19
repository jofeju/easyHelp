package br.uem.easyhelp.exceptions;

/**
 * @author Douglas
 */
public class CardException extends Exception {
    public CardException(Throwable cuase) {
        super(cuase);
    }

    public CardException(String message) {
        super(message);
    }

    public CardException(String message, Throwable cause) {
        super(message, cause);
    }
}
