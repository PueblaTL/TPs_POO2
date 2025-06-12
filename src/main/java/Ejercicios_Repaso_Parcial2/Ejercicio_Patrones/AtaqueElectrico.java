package Ejercicios_Repaso_Parcial2.Ejercicio_Patrones;

public class AtaqueElectrico extends Ataque{
    public AtaqueElectrico(int poderBase, boolean climaAFavor, int defensaOponente) {
        super(poderBase, climaAFavor, defensaOponente);
    }

    protected double getModificadorTipo() { return 1.2; }
    protected double getBonificacionClima() { return climaAFavor ? 1.2 : 1.0; }
}
