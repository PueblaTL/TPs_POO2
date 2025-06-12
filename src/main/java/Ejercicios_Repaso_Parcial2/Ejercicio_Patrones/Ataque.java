package Ejercicios_Repaso_Parcial2.Ejercicio_Patrones;

abstract class Ataque {
    protected int poderBase;
    protected boolean climaAFavor;
    protected int defensaOponente;

    public Ataque(int poderBase, boolean climaAFavor, int defensaOponente) {
        this.poderBase = poderBase;
        this.climaAFavor = climaAFavor;
        this.defensaOponente = defensaOponente;
    }

    public final double calcularDanio() {
        double modificadorTipo = getModificadorTipo();
        double bonificacionClima = getBonificacionClima();
        double danioBase = poderBase * modificadorTipo * bonificacionClima;
        return danioBase - defensaOponente * 0.5;
    }

    protected abstract double getModificadorTipo();
    protected abstract double getBonificacionClima();
}
