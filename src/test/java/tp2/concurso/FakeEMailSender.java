package tp2.concurso;
import tp2.concurso.persistance.EmailSender;

public class FakeEmailSender extends EmailSender {

    private String ultimoEmailEnviado = "";
    private String ultimoDestinatario = "";

    public FakeEmailSender() {
        super("", 0, "", ""); // no se usa
    }

    @Test
    public void testInscripcionEnviaCorreo() {
        FakeEmailSender fakeEmail = new FakeEmailSender();
        Almacenamiento almacenamientoFalso = new FakeAlmacenamiento(); // si tenés uno

        Concurso concurso = new Concurso(LocalDate.now(), LocalDate.now().plusDays(10), almacenamientoFalso, fakeEmail);

        Participante p = new Participante(123, "Juan", "juan@email.com");
        concurso.inscribirParticipante(p);

        assertFalse(fakeEmail.getEnviados().isEmpty());
    }


    public String getUltimoDestinatario() {
        return ultimoDestinatario;
    }

    public String getUltimoEmail() {
        return ultimoEmailEnviado;
    }
}
