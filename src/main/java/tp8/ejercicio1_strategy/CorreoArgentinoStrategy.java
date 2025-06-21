package tp8.ejercicio1_strategy;

public class CorreoArgentinoStrategy implements EstrategiaEnvio {
    @Override
    public double calcularCostoEnvio(String destino, double pesoTotal) {
        if (destino.toLowerCase().equals("capital federal") || 
            destino.toLowerCase().equals("caba")) {
            return 500;
        }
        
        // Para otros destinos: costo fijo + (5 * distancia en km)
        double costoFijo = 800;
        int distanciaKm = ServicioDistancia.obtenerDistancia(destino);
        double costoPorDistancia = 5 * distanciaKm;
        
        return costoFijo + costoPorDistancia;
    }
}