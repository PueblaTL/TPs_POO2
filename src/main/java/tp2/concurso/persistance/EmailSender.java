package tp2.concurso.persistance;

import tp2.concurso.email.IEmailSender;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailSender implements IEmailSender {
    private final String username;
    private final String password;

    public EmailSender(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void enviarEmail(String destinatario, String asunto, String cuerpo) {
        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.host", "smtp.mailtrap.io");
        propiedades.put("mail.smtp.port", "2525");

        Session session = Session.getInstance(propiedades, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress("noreply@concurso.com"));
            mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            mensaje.setSubject(asunto);
            mensaje.setText(cuerpo);

            Transport.send(mensaje);
        } catch (MessagingException e) {
            throw new RuntimeException("Error al enviar el correo: " + e.getMessage(), e);
        }
    }
}

