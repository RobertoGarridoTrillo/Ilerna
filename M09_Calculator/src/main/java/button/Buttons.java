package button;

public enum Buttons {

    CERO, UNO, DOS, TRES, CUATRO, CINCO, SEIS, SIETE, OCHO, NUEVE,
    SUMAR, RESTAR, MULTIPLICAR, DIVIDIR,
    BORRARPARTE, BORRARTODO, BORRARATRAS,
    MASMENOS, COMA, IGUAL,
    CUADRADO, TANTOPORCIENTO, RAIZCUADRADA, FRACCION,
    BUTTONSNAME;

    // or I passed the method to static or I added the name of the method to the ENUM list
    // This method returns the Enum Button it match with the parameter passed.
    public Buttons buttonName(int i) {

        Buttons buttonsOut = null;

        for (Buttons buttons : Buttons.values()) {

            if (buttons.ordinal() == i) {
                buttonsOut = buttons;
                break;
            }
        }
        if (buttonsOut == null) {
            throw new AssertionError();
        } else {
            return buttonsOut;
        }
    }
}
