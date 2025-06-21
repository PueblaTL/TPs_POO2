package tp8.ejercicio2_strategy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class fechaLarga implements FechaNac{

    @Override
    public String getFecha(LocalDate fechaNacimiento) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy");
        return fechaNacimiento.format(formato);
    }
}