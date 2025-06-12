package Ejercicios_Repaso_Parcial2.Ataques;
// Extraigo la lógica común de cálculo de daño en una superclase abstracta Ataque,
// y dejo que las subclases implementen los detalles del modificador de tipo y del clima
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
