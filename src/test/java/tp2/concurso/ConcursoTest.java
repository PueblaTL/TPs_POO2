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
    static String DIRECTORIO ="C:\\Users\\agupu\\Desktop\\Universidad Agustin\\Materias\\Tercer Año\\POO2-Practicos\\tmp\\detalle.txt";

    @Test
    public void inscribirParticipanteDentroDelPlazo() throws IOException {
        // Crea un archivo para pruebas
        var directorio = Paths.get(DIRECTORIO);
        Files.deleteIfExists(directorio);

        //configuración del concurso
        var fechaApertura = LocalDate.now().minusDays(2);
        var fechaLimite = fechaApertura.plusDays(10);
        var fakeInscripcion = new FakeEscritorDeArchivo();
        var concurso = new Concurso(fechaApertura, fechaLimite);
        concurso.setAlmacenamiento(new AlmacenamientoAdapter(fakeInscripcion));  // Usar un adaptador

        // Participante
        var participante = new Participante(123456, "Julian Gonzalez");
        var participante2 = new Participante(82581, "Mariano Rodriguez");

        // Inscripción
        concurso.inscribirParticipante(participante);
        concurso.inscribirParticipante(participante2);

        // Verificar inscripción
        assertTrue(concurso.existParticipante(participante));
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

        // Uso de un constructor sin el almacenamiento, y luego configurándolo
        Concurso concurso = new Concurso(fechaApertura, fechaLimite);
        concurso.setAlmacenamiento(new AlmacenamientoAdapter(escritorArchivo));

        // Participante
        Participante participante = new Participante(293235, "Luciano Pelozo");

        // Inscripción
        concurso.inscribirParticipante(participante);

        // Verifica la inscripción y los puntos
        assertEquals(10, participante.getPuntos());
    }

    @Test
    public void inscribirParticipanteFueraDelPlazo() {
        Path directorio = Paths.get(DIRECTORIO);
        EscritorArchivo escritorArchivo = new EscritorDeArchivoEnDisco(directorio.toString());


        LocalDate fechaApertura = LocalDate.now().minusDays(20); // Fecha pasada
        LocalDate fechaLimite = fechaApertura.plusDays(10);


        Concurso concurso = new Concurso(fechaApertura, fechaLimite);
        concurso.setAlmacenamiento(new AlmacenamientoAdapter(escritorArchivo));

        Participante participante = new Participante(338965, "Luis Suarez");


        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            concurso.inscribirParticipante(participante); });


        assertEquals(Concurso.FUERA_DE_PLAZO, exception.getMessage());
    }

    private static class AlmacenamientoAdapter implements Almacenamiento {
        private final EscritorArchivo escritorArchivo;

        public AlmacenamientoAdapter(EscritorArchivo escritorArchivo) {
            this.escritorArchivo = escritorArchivo;
        }

        @Override
        public void guardarInscripcion(String info) {
            escritorArchivo.guardarInscripcion(info);
        }
    }
}
