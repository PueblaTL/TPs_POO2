package tp8.ejercicio2_strategy;


import java.time.LocalDate;

public class Persona {
    private FechaNac formatoFecha;
    private LocalDate fechaNacimiento;

    public Persona (LocalDate fechaNacimiento, FechaNac formatoFecha) {
        this.fechaNacimiento = fechaNacimiento;
        this.formatoFecha = formatoFecha;
    }
    public String fechaNacimiento() {
        return formatoFecha.getFecha(this.fechaNacimiento);
    }
    public void setFormatoFecha(FechaNac fechaNac){
        this.formatoFecha = fechaNac;
    }
}
