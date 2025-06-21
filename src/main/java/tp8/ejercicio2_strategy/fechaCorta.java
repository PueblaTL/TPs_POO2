package tp8.ejercicio2_strategy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class fechaCorta implements FechaNac{

    public String getFecha(LocalDate fechaNacimiento) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fechaNacimiento.format(formato);
    }
}