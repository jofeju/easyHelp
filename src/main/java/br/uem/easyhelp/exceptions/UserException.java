package br.uem.easyhelp.exceptions;

/**
 * @author Douglas
 */
public class UserException extends Exception {
    public UserException(Throwable cuase) {
        super(cuase);
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }
}
