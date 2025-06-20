package tp6.ejercicio5_decorador;

public class ConcursoConEmail extends ConcursoDecorator {
    private final EmailService emailService;

    public ConcursoConEmail(RegistroDeInscripcion concurso, EmailService emailService) {
        super(concurso);
        this.emailService = emailService;
    }

    @Override
    public void inscribirParticipante(Participante participante) {
        super.inscribirParticipante(participante);

        String asunto = "Confirmación de inscripción";
        String mensaje = "Hola " + participante.getId() + ", te has inscrito exitosamente al concurso.";

        emailService.enviarEmail(participante.getEmail(), asunto, mensaje);
    }
}
