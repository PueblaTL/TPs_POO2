package tp8.ejercicio1_strategy;

public class CalculadorEnvio {
    private EstrategiaEnvio estrategia;
    
    public CalculadorEnvio(EstrategiaEnvio estrategia) {
        this.estrategia = estrategia;
    }
    
    public void setEstrategia(EstrategiaEnvio estrategia) {
        this.estrategia = estrategia;
    }
    
    public double calcularCostoEnvio(String destino, double pesoTotal) {
        return estrategia.calcularCostoEnvio(destino, pesoTotal);
    }
}