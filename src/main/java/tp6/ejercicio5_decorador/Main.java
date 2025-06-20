package tp6.ejercicio5_decorador;

public class Main {
    public static void main(String[] args) {
        Participante p = new Participante("Juan", "test@mailtrap.io");
        Concurso concursoBase = new Concurso("decoradores");

        EmailService emailService = new EmailServiceImplement();

        // Decorar el concurso con funcionalidad de envío de email
        RegistroDeInscripcion concurso = new ConcursoConEmail(concursoBase, emailService);

        concurso.inscribirParticipante(p); // Esto inscribe al participante y le envía un email
    }
}

