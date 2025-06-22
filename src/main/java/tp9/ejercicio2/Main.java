package tp9.ejercicio2;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        var juan = new Usuario("Juan", List.of(Permiso.ADMIN));
        var pablo = new Usuario("Pablo", List.of(Permiso.BASICO));
        var fileAccess = new FileAccess("C:/Users/agupu/Documents/Universidad/POO_2/TPs_POO2/Recursos/Archivos", "idpermisos.txt");
        var acceso = new ProxyFileAcces(fileAccess, juan);
        var acceso2 = new ProxyFileAcces(fileAccess, pablo);
        try {
            acceso.readFile();
            acceso2.readFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}