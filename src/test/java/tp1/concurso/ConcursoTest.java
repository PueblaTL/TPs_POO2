package tp1.concurso;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ConcursoTest {

    @Test
    public void inscribirParticipanteDentroDelPlazo() {
        // Configuración del concurso
        LocalDate fechaApertura = LocalDate.now().minusDays(2);
        LocalDate fechaLimite = fechaApertura.plusDays(10);
        Concurso concurso = new Concurso(fechaApertura, fechaLimite);
        //Concurso concurso2 = new Concurso(fechaApertura.plusDays(10), fechaLimite.plusDays(10));

        // Participante
        Participante participante = new Participante(12345, "Amelia Gonzalez");
        Participante participante2 = new Participante(12221, "Maria Rosa");

        // Inscripción
        concurso.inscribirParticipante(participante);

        // Verificar inscripción
        assertTrue(concurso.existParticipante(participante));
    }

    @Test
    public void inscribirParticipantePrimerDiaDeApertura() {
        // Configuración del concurso
        LocalDate fechaApertura = LocalDate.now();
        LocalDate fechaLimite = fechaApertura.plusDays(10);
        Concurso concurso = new Concurso(fechaApertura, fechaLimite);

        // Participante
        Participante participante = new Participante(12921, "Laura Lopez");

        // Inscripción
        concurso.inscribirParticipante(participante);

        // Verificar inscripción y puntos
        assertTrue(concurso.existParticipante(participante));
        assertEquals(10, participante.getPuntos()); // Ganó puntos por inscribirse el primer día
    }

    @Test
    public void inscribirParticipanteFueraDelPlazo() {
        // Configuración del concurso
        LocalDate fechaApertura = LocalDate.now().minusDays(20); // Fecha pasada
        LocalDate fechaLimite = fechaApertura.plusDays(10);
        Concurso concurso = new Concurso(fechaApertura, fechaLimite);

        // Participante
        Participante participante = new Participante(38336, "Rocio Paredes");

        // Intento de inscripción
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            concurso.inscribirParticipante(participante); });

        // Verificar mensaje de error fuera de plazo
        assertEquals(Concurso.FUERA_DE_PLAZO, exception.getMessage());
    }
}