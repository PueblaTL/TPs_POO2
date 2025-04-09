package tp2.concurso;

import org.junit.jupiter.api.Test;
import tp2.concurso.persistance.EscritorDeArchivoEnDisco;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ConcursoTest {
    static String DIRECTORIO ="C:\\Users\\agupu\\Desktop\\Universidad Agustin\\Materias\\Tercer Año\\POO2-Practicos\\tmp\\inscripcion.txt";

    @Test
    public void inscribirParticipanteDentroDelPlazo() throws IOException {
        // Crear archivo para pruebas
        var directorio = Paths.get(DIRECTORIO);
        Files.deleteIfExists(directorio); // Limpieza del archivo

        // Configuración del concurso
        var fechaApertura = LocalDate.now().minusDays(2);
        var fechaLimite = fechaApertura.plusDays(10);
        //    Concurso concurso = new Concurso(fechaApertura, fechaLimite, new EscritorDeArchivoEnDisco(directorio.toString())); // Test En Disco
        var fakeInscripcion =  new FakeEscritorDeArchivo();
        var concurso = new Concurso(fechaApertura, fechaLimite,fakeInscripcion);  // Test En Memoria

        // Participante
        var participante = new Participante(123456, "Julian Gonzalez");
        var participante2 = new Participante(293235, "Luciano Pelozo");

        // Inscripción
        concurso.inscribirParticipante(participante);
        concurso.inscribirParticipante(participante2);

        // Verificar inscripción
        //    assertTrue(concurso.existParticipante(participante));
        assertTrue(fakeInscripcion.startWith("Fecha"));

    }

    @Test
    public void inscribirParticipantePrimerDiaDeApertura() {
        // Uso del archivo para pruebas
        Path directorio = Paths.get(DIRECTORIO);
        // Configurar el escritor de archivo con la ruta
        EscritorArchivo escritorArchivo = new EscritorDeArchivoEnDisco(directorio.toString());

        // Configuración del concurso
        LocalDate fechaApertura = LocalDate.now();
        LocalDate fechaLimite = fechaApertura.plusDays(10);
        Concurso concurso = new Concurso(fechaApertura, fechaLimite,escritorArchivo);

        // Participante
        Participante participante = new Participante(338965, "Luis Suarez");

        // Inscripción
        concurso.inscribirParticipante(participante);

        // Verificar inscripción y puntos
        assertTrue(concurso.existParticipante(participante));
        assertEquals(10, participante.getPuntos()); // Ganó puntos por inscribirse el primer día
    }

    @Test
    public void inscribirParticipanteFueraDelPlazo() {
        // Uso del archivo para pruebas
        Path directorio = Paths.get(DIRECTORIO);
        // Configurar el escritor de archivo con la ruta
        EscritorArchivo escritorArchivo = new EscritorDeArchivoEnDisco(directorio.toString());

        // Configuración del concurso
        LocalDate fechaApertura = LocalDate.now().minusDays(20); // Fecha pasada
        LocalDate fechaLimite = fechaApertura.plusDays(10);
        Concurso concurso = new Concurso(fechaApertura, fechaLimite,escritorArchivo);

        // Participante
        Participante participante = new Participante(28463, "Luis Diaz");

        // Intento de inscripción
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            concurso.inscribirParticipante(participante); });

        // Verificar mensaje de error fuera de plazo
        assertEquals(Concurso.FUERA_DE_PLAZO, exception.getMessage());
    }
}