package Ejercicios_Repaso_Parcial2.Ejercicio_Patrones;

class AtaqueFuego extends Ataque {
    public AtaqueFuego(int poderBase, boolean climaAFavor, int defensaOponente) {
        super(poderBase, climaAFavor, defensaOponente);
    }

    protected double getModificadorTipo() { return 1.2; }
    protected double getBonificacionClima() { return climaAFavor ? 1.5 : 1.0; }
}
