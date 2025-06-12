package Ejercicios_Repaso_Parcial2.Ataques;;

class AtaqueAgua extends Ataque {
    public AtaqueAgua(int poderBase, boolean climaAFavor, int defensaOponente) {
        super(poderBase, climaAFavor, defensaOponente);
    }

    protected double getModificadorTipo() { return 1.2; }
    protected double getBonificacionClima() { return climaAFavor ? 1.3 : 1.0; }
}
