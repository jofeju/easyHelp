package br.uem.easyhelp.metadata.type;

/**
 * @author Douglas
 */
public enum CardType {
    BAIXA("Baixa"),
    ALTA("Alta"),
    CRITICA("Crítica");

    private String textValue;

    CardType(String textValue) {
        this.textValue = textValue;
    }

    public String getTextValue() {
        return textValue;
    }
}
