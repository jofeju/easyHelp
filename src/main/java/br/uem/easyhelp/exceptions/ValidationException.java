package br.uem.easyhelp.exceptions;

/**
 * @author Douglas
 */
public class ValidationException extends Exception {
    public ValidationException(Throwable cuase) {
        super(cuase);
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
