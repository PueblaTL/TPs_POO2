package tp8.ejercicio1_strategy;

public class ColectivosSurStrategy implements EstrategiaEnvio {
    @Override
    public double calcularCostoEnvio(String destino, double pesoTotal) {
        double costoBase = 0;
        
        // Determina el costo base según destino
        switch (destino.toLowerCase()) {
            case "capital federal":
            case "caba":
                costoBase = 1000;
                break;
            case "gran buenos aires":
            case "gba":
                costoBase = 1500;
                break;
            default:
                costoBase = 3000;
                break;
        }
        
        // Calcula el adicional por peso
        double adicionalPeso = 0;
        if (pesoTotal > 5 && pesoTotal <= 30) {
            adicionalPeso = 500;
        } else if (pesoTotal > 30) {
            adicionalPeso = 2000;
        }
        
        return costoBase + adicionalPeso;
    }
}
