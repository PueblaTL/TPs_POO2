package tp4.ejercicio3.main;
import tp4.ejercicio3.modelo.ConcursoRepository;
import tp4.ejercicio3.modelo.InscripcionRepository;
import tp4.ejercicio3.persistencia.ArchivoConcursoRepository;
import tp4.ejercicio3.persistencia.ArchivoInscripcionRepository;

import tp4.ejercicio3.persistencia.JdbcConcursoRepository;
import tp4.ejercicio3.persistencia.JdbcInscripcionRepository;
import tp4.ejercicio3.persistencia.SetupBaseDeDatos;
import tp4.ejercicio3.ui.RadioCompetitionView;

import javax.swing.SwingUtilities;
import java.sql.SQLException;

public class Main {


    private static final String RUTA_CONCURSOS_TXT = "concursos.txt";
    private static final String RUTA_INSCRIPTOS_TXT = "inscriptos.txt";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root" ;
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "123456";


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Aca se elije que persistencia usar
                boolean usarBaseDeDatos = false; // Cambia a true para usar JDBC

                new Main().start(usarBaseDeDatos);

            } catch (Exception e) {
                e.printStackTrace(); // Imprime el stack trace en la consola de error
   }
        });
    }


    private void start(boolean usarBD) {
        ConcursoRepository repoConcursos;
        InscripcionRepository repoInscripciones;

        if (usarBD) {
            try {

                SetupBaseDeDatos.crearTablasSiNoExisten(DB_URL, DB_USER, DB_PASSWORD);

                repoConcursos = new JdbcConcursoRepository(DB_URL, DB_USER, DB_PASSWORD);
                repoInscripciones = new JdbcInscripcionRepository(DB_URL, DB_USER, DB_PASSWORD);

            } catch (SQLException e) {
                // Fallback a archivos o lanzar error? Por ahora, lanzamos RuntimeException
                throw new RuntimeException("No se pudo inicializar la persistencia JDBC", e);
            }
        } else {
            repoConcursos = new ArchivoConcursoRepository(RUTA_CONCURSOS_TXT);
            repoInscripciones = new ArchivoInscripcionRepository(RUTA_INSCRIPTOS_TXT);
        }

        new RadioCompetitionView(repoConcursos, repoInscripciones);
    }
}