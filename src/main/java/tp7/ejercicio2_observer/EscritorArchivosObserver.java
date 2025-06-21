package tp7.ejercicio2_observer;

import tp7.ejercicio1_observer.Observer;

import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class EscritorArchivosObserver implements Observer {
    private final String rutaArchivo;

    public EscritorArchivosObserver(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public void notificar(String temperatura, java.time.LocalDateTime fecha) {
        String linea = fecha.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                       + " - " + temperatura + System.lineSeparator();
        try (FileWriter fw = new FileWriter(rutaArchivo, true)) {
            fw.write(linea);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
