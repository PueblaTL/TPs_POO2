package tp6.ejercicio3_decorador;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class ReportOverwrite extends ReportDecorador {

    public ReportOverwrite(Exportador decorado) {
        super(decorado);
    }

    @Override
    public void exportar(File file) {
        if (file == null) {
            throw new IllegalArgumentException("File es NULL; no puedo exportar...");
        }

        try (FileWriter writer = new FileWriter(file)) { // FileWriter sobreescribe por defecto
            if (decorado instanceof Report) {
                writer.write(((Report) decorado).getContenido());
            } else {
                decorado.exportar(file);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al exportar el reporte", e);
        }
    }
}
