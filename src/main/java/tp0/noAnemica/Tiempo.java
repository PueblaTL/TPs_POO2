package tp0.noAnemica;

import java.time.*;

public class Tiempo {
    private LocalDate fecha;

    public Tiempo(){
        this.fecha = LocalDate.now();
    }
    public LocalDate getFecha() {
        return fecha;
    }
}