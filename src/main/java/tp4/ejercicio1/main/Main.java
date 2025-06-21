package tp4.ejercicio1.main;

import tp4.ejercicio1.database.JDBCRegistroParticipante;
import tp4.ejercicio1.model.Concurso;
import tp4.ejercicio1.ui.VentanaPrincipal;
import tp7.ejercicio4_observer.EmailNotifier;
import tp6.ejercicio5_decorador.EmailService;
import tp6.ejercicio5_decorador.EmailServiceImplement;


import java.awt.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    var registroParticipante = new JDBCRegistroParticipante(
                            "jdbc:derby://localhost:1527/participantes",
                            "app",
                            "app"
                    );

                    var concurso = new Concurso(registroParticipante);

                    EmailService emailService = new EmailServiceImplement();
                    concurso.agregarObservador(new EmailNotifier(emailService));

                    new VentanaPrincipal(concurso).AgregarParticipante();

                    new VentanaPrincipal(concurso).AgregarParticipante();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}