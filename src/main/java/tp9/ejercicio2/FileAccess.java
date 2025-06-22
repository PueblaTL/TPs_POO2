package tp9.ejercicio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileAccess implements AccesoArchivos {
    private String ruta;
    private String nombre;

    public FileAccess(String ruta, String nombre) {
        this.ruta = ruta;
        this.nombre = nombre;
    }

    public String readFile() throws IOException {
        return Files.readString(Paths.get(this.ruta + "/" + this.nombre));
    }

    public boolean empiezaCon(String letra) {
        return this.nombre.startsWith(letra);
    }
}
