package tp2.concurso;
public class FakeEmailService implements EmailService {
    private String destinatario;
    private String asunto;
    private String mensaje;

    @Override
    public void enviarEmail(String destinatario, String asunto, String mensaje) {
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }

    public boolean destinarioStartWith (String inicio) {return this.destinatario.startsWith(inicio);}

    public boolean asuntoStartWith (String inicio) {return this.asunto.startsWith(inicio);}

    public boolean mensajeStartWith (String inicio) {return this.mensaje.startsWith(inicio);}
}
