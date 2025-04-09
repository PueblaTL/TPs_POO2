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

        // Instanciar el EmailSender con tus datos de Mailtrap
        EmailSender emailSender = new EmailSender(
                "sandbox.smtp.mailtrap.io",
                2525,
                "f5d2f689d53a50",
                "f92a5b2a23a391"
        );

        // Inscribir participantes
        Participante participante1 = new Participante(897654, "Lionel Messi", "LeoMessi@gmail.com");

        concurso.inscribirParticipante(participante1);
        emailSender.enviarEmail(
                "Bienvenido al concurso",
                "Hola"+participante1.getNombre()+", ¡gracias por registrarte!"
        );

    }
}
