package tp2.concurso;

import tp2.concurso.persistance.AlmacenamientoBaseDatosConcurso;
import tp2.concurso.persistance.EmailSender;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Usar base de datos
        Almacenamiento almacenamientoBaseDatos = new AlmacenamientoBaseDatosConcurso();
        EmailSender emailSender = new EmailSender();

        // Configurar Concurso
        LocalDate fechaApertura = LocalDate.now();
        LocalDate fechaLimite = fechaApertura.plusDays(10);
        Concurso concurso = new Concurso(fechaApertura, fechaLimite, almacenamientoBaseDatos,emailSender);

        // Inscribir participante
        Participante participante = new Participante(897654, "Lionel Messi", "LeoMessi@gmail.com");
        concurso.inscribirParticipante(participante);
    }
}