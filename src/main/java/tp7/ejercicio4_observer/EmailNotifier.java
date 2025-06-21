package tp7.ejercicio4_observer;

import tp4.ejercicio1.model.Participante;
import tp6.ejercicio5_decorador.EmailService;


public class EmailNotifier implements ParticipanteObserver {
    private EmailService emailService;

    public EmailNotifier(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void notificar(Participante participante) {
        String asunto = "Confirmación de inscripción";
        String cuerpo = "Hola " + participante.getNombre() + ", estás inscripto en el concurso. ¡Éxitos!";
        emailService.enviarEmail(participante.getEmail(), asunto, cuerpo);
    }

    //lo demas lo implemente haciendo cambios al ejercicio 1 de layers
}
