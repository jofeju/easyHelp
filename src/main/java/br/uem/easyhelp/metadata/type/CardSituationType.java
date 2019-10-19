package br.uem.easyhelp.metadata.type;

/**
 * @author Douglas
 */
public enum CardSituationType {
    ABERTO("Aberto"),
    FINALIZADO("Finalizado"),
    CANCELADO("Cancelado"),
    AGUARDANDO_ANALISE("Aguardando análise");

    private String textValue;

    CardSituationType(String textValue) {
        this.textValue = textValue;
    }

    public String getTextValue() {
        return textValue;
    }
}
