package Ejercicios_Repaso_Parcial2.Ejercicio_Patrones;

class  Ataque {
    public TipoAtaque tipo;
    public int poderBase;
    public boolean climaAFavor;
    public int defensaOponente;

    public Ataque(TipoAtaque tipo, int poderBase, boolean climaAFavor, int defensaOponente) {
        this.tipo = tipo;
        this.poderBase = poderBase;
        this.climaAFavor = climaAFavor;
        this.defensaOponente = defensaOponente;
    }

    public double calcularDanio() {
        double modificadorTipo = 1.0;
        double bonificacionClima = 1.0;
        double defensa = defensaOponente;

        if (tipo == TipoAtaque.FUEGO) {
            modificadorTipo = 1.2;
            if (climaAFavor) bonificacionClima = 1.5;
        } else if (tipo == TipoAtaque.AGUA) {
            modificadorTipo = 1.1;
            if (climaAFavor) bonificacionClima = 1.3;
        } else if (tipo == TipoAtaque.PLANTA) {
            modificadorTipo = 1.0;
            if (climaAFavor) bonificacionClima = 1.2;
        } else if (tipo == TipoAtaque.ELECTRICO) {
            modificadorTipo = 1.3;
            if (climaAFavor) bonificacionClima = 1.1;
        }

        double danioBase = poderBase * modificadorTipo * bonificacionClima;
        return danioBase - defensa * 0.5;
    }
}
