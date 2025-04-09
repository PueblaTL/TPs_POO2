package tp0.anemico;

import java.time.LocalDate;
import java.time.format.*;

public class Tiempo {
    private LocalDate fecha;

    public Tiempo(){
        this.fecha = LocalDate.now();
    }
    public String obtenerFechaLarga() {
        return fecha.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
    }
    public String obtenerFechaCorta() {
        return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}

