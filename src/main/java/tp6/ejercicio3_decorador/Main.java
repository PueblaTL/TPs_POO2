package tp6.ejercicio3_decorador;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Report reporte = new Report("Este es el contenido del reporte");

        File archivo1 = new File("resumen.txt");

        // No permite sobrescribir
        try {
            reporte.exportar(archivo1);
        } catch (Exception e) {
            System.out.println("No sobrescribe: " + e.getMessage());
        }

        // Permite sobrescribir
        Exportador sobrescribir = new ReportOverwrite(reporte);
        sobrescribir.exportar(archivo1);
    }
}
