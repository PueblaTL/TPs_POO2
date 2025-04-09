package tp2.restaurante.persistance;

import tp2.restaurante.EscritorArchivo;
import tp2.restaurante.Almacenamiento;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscritorDeArchivoEnDisco implements EscritorArchivo,Almacenamiento { // implement de escritura en disco y db
    private String rutaArchivo;

    public EscritorDeArchivoEnDisco(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public void guardarDetalle(String contenido) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            writer.write(contenido);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar: " + e.getMessage());
        }
    }
}
