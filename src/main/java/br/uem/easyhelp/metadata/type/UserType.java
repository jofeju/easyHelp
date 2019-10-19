package br.uem.easyhelp.metadata.type;

/**
 * @author Douglas
 */
public enum UserType {
    ADMIN("Administrador"),
    DEFAULT("Jogador");

    private String textValue;

    UserType(String textValue) {
        this.textValue = textValue;
    }

    public String getTextValue() {
        return textValue;
    }
}
