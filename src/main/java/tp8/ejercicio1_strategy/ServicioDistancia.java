package tp8.ejercicio1_strategy;

public class ServicioDistancia {
    public static int obtenerDistancia(String destino) {
        // Se simula el servicio web http://distancia.ar
        switch (destino.toLowerCase()) {
            case "cordoba": return 700;
            case "rosario": return 300;
            case "mendoza": return 1000;
            case "tucuman": return 1200;
            case "bariloche": return 1600;
            default: return 500;
    }
}
}