package Ejercicios_Repaso_Parcial2.Ejercicio_Patrones;

public class AtaquePlanta extends Ataque {
    public AtaquePlanta(int poderBase, boolean climaAFavor, int defensaOponente) {
        super(poderBase, climaAFavor, defensaOponente);
    }

    protected double getModificadorTipo() { return 1.2; }
    protected double getBonificacionClima() { return climaAFavor ? 1.1 : 1.0; }
}
