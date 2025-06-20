package tp6.ejercicio3_decorador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Report implements Exportador {
    private String reporte;

    public Report(String report) {
        this.reporte = report;
    }

    @Override
    public void exportar(File file) {
        if (file == null) {
            throw new IllegalArgumentException("File es NULL; no puedo exportar...");
        }
        if (file.exists()) {
            throw new IllegalArgumentException("El archivo ya existe...");
        }

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(reporte);
        } catch (IOException e) {
            throw new RuntimeException("Error al exportar el reporte", e);
        }
    }
    public String getContenido() {
        return reporte;
    }

}

