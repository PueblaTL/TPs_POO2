package tp0.noAnemica;

import java.time.format.*;

public class Main{
    public static void main(String[] args) {
        Tiempo tiempo = new Tiempo();

        // Formato largo
        String formatoLargo = tiempo.getFecha().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        System.out.println("Fecha en formato largo: " + formatoLargo);

        // Formato corto
        String formatoCorto = tiempo.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Fecha en formato corto: " + formatoCorto);
    }

}