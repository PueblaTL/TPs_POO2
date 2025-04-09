package tp2.concurso.persistance;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

    public class EmailSender {
        this.username = "f5d2f689d53a50";
        this.password = "f92a5b2a23a391";

        public void enviarEmail(String destinatario, String asunto, String mensaje) {
            // Configuración del servidor SMTP
            Properties propiedades = new Properties();
            propiedades.put("mail.smtp.auth", "true");
            propiedades.put("mail.smtp.starttls.enable", "true");
            propiedades.put("mail.smtp.host", "smtp.mailtrap.io");
            propiedades.put("mail.smtp.port", "2525");

            // Crear una sesión con autenticación
            Session session = Session.getInstance(propiedades, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            try {
                // Construir el mensaje
                Message correo = new MimeMessage(session);
                correo.setFrom(new InternetAddress("noreply@concurso.com")); // Dirección del remitente
                correo.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario)); // Destinatario
                correo.setSubject(asunto); // Asunto
                correo.setText(mensaje); // Cuerpo del mensaje

                // Enviar el correo
                Transport.send(correo);

            } catch (MessagingException e) {
                throw new RuntimeException("Error al enviar el correo: " + e.getMessage(), e);
            }
        }
    }