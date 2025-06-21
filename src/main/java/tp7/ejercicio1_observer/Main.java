package tp7.ejercicio1_observer;


import tp7.ejercicio2_observer.ConsolaObserver;
import tp7.ejercicio2_observer.EscritorArchivosObserver;

import java.io.File;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ClimaOnline servicio = new WeatherChannelService();
        Medidor medidor = new Medidor(servicio);

        String carpeta = "C:\\Users\\agupu\\Documents\\Universidad\\POO_2\\TPs_POO2\\Recursos\\Archivos";
        String nombreArchivo = "registro_temperaturas.txt";
        String rutaCompleta = carpeta + File.separator + nombreArchivo;

        // Asegurarnos de que la carpeta existe:
        File dir = new File(carpeta);
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                System.err.println("No se pudo crear el directorio: " + carpeta);
                return;
            }
        }

        // Registramos observadores con la ruta absoluta
        medidor.agregar(new EscritorArchivosObserver(rutaCompleta));
        medidor.agregar(new ConsolaObserver());

        // Simulamos lecturas
        for (int i = 0; i < 5; i++) {
            System.out.println("Temperatura actual: " + medidor.leerTemperatura());
            Thread.sleep(5000);
        }
    }
}

