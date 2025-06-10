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
    static String DIRECTORIO ="C:\\Users\\agupu\\Documents\\GitHub\\Archivos\\Inscripciones.txt";


    @Test
    public void inscribirParticipanteDentroDelPlazo() throws IOException {
        // Crear archivo para pruebas
        var directorio = Paths.get(DIRECTORIO);
        Files.deleteIfExists(directorio); // Limpieza del archivo

        // Configuración del concurso
        var fechaApertura = LocalDate.now().minusDays(2);
        var fechaLimite = fechaApertura.plusDays(10);
        var fakeInscripcion =  new FakeEscritorDeArchivo();
        var fakeAlmacenamientoBD =  new FakeAlmacenamiento();
        var fakeEmail =  new FakeEmailService();

        var concurso = new Concurso(fechaApertura, fechaLimite,fakeAlmacenamientoBD,fakeEmail);


        // Participante
        var participante = new Participante(12345, "Juan Perez","email@email.email");
        var participante2 = new Participante(54321, "Martín Ramos","asd@asd.asd");

        // Inscripción
        concurso.inscribirParticipante(participante);
        concurso.inscribirParticipante(participante2);

        // Verificar inscripción
        assertTrue(fakeAlmacenamientoBD.startWith("Fecha de Inscripción: ")); // Assert para Almacenamientobd
        assertTrue(fakeEmail.mensajeStartWith("Hola ")); // Assert para Email
        assertTrue(fakeEmail.destinarioStartWith("asd@asd.asd")); // Assert para Email
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
        Participante participante = new Participante(98765, "Pedro Meza");

        // Intento de inscripción
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            concurso.inscribirParticipante(participante); });

        // Verificar mensaje de error fuera de plazo
        assertEquals(Concurso.FUERA_DE_PLAZO, exception.getMessage());
    }
}