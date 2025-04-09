package tp2.concurso;
import tp2.concurso.persistance.AlmacenamientoBaseDatosConcurso;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Uso de la base de datos
        Almacenamiento almacenamientoBaseDatos = new AlmacenamientoBaseDatosConcurso();

        // Configura el Concurso
        LocalDate fechaApertura = LocalDate.now();
        LocalDate fechaLimite = fechaApertura.plusDays(10);
        Concurso concurso = new Concurso(fechaApertura, fechaLimite, almacenamientoBaseDatos);

        // Inscribir participante
        Participante participante = new Participante(897654, "Lionel Messi");
        var participante2 = new Participante(283765, "Joaquin Lopez");
        concurso.inscribirParticipante(participante);
        concurso.inscribirParticipante(participante2);
    }
}