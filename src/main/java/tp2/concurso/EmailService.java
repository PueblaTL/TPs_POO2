package tp2.concurso;

public interface EmailService {
    void enviarEmail(String destinatario, String asunto, String mensaje);
}