package tp2;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.util.Properties;

public class EmailSender {
    private final String host;
    private final int port;
    private final String username;
    private final String password;

    public EmailSender() {
        this.host = "sandbox.smtp.mailtrap.io";
        this.port = 2525;
        this.username = "f5d2f689d53a50";
        this.password = "f92a5b2a23a391";
    }


    public void enviarEmail(String destinatario, String asunto, String cuerpo) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", String.valueOf(port));

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress("noreply@miapp.com")); // quien lo envía
            mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            mensaje.setSubject(asunto);
            mensaje.setText(cuerpo);

            Transport.send(mensaje);
            System.out.println("📩 Email enviado con éxito a " + destinatario);

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al enviar el email", e);
        }
    }
}