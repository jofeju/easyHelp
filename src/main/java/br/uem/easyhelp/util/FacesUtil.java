package br.uem.easyhelp.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil {
    public static String INDEX_FACE = "/restricted/index?faces-redirect=true";
    public static String LOGIN_FACE = "/security/login?faces-redirect=true";
    public static String USER_FACE = "/restricted/user";
    public static String USER_CREATE_FACE = "/restricted/user-create";
    public static String USER_EDIT_FACE = "/restricted/user-edit";
    public static String JOGO_FACE = "/restricted/jogo";
    public static String JOGO_CREATE_FACE = "/restricted/jogo-create";
    public static String JOGO_EDIT_FACE = "/restricted/jogo-edit";
    public static String CARD_SEARCH_FACE = "/restricted/card";
    public static String CARD_EDIT_FACE = "/restricted/card-edit";

    public static void displayError(String text) {
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", text));
    }
}
