package tp0.anemico;

public class Main {
        public static void main(String[] args) {
        Tiempo tiempo = new Tiempo();
        System.out.println("Fecha en formato largo: " + tiempo.obtenerFechaLarga());
        System.out.println("Fecha en formato corto: " + tiempo.obtenerFechaCorta());
    }

}
