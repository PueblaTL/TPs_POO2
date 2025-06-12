package Ejercicios_Repaso_Parcial2.Ataques;

import java.util.List;

//Implemento el patron composite al poder crear ataques compuestos que puedan ser usados como otro ataque normal,
// asi quedaria los ataques de tipo como hojas y el ataque compuesto como lo seria un triplerayo como un composite.

public class AtaqueCompuesto extends Ataque{
        private List<Ataque> ataques;

        public AtaqueCompuesto(List<Ataque> ataques) {
            super(0, false, 0);
            this.ataques = ataques;
        }

        public void agregarAtaque(Ataque ataque) {
        ataques.add(ataque);
        }


    @Override
    protected double getModificadorTipo() {
        return 1.0; // valor neutro, se ignora en ataques combinados
    }

    @Override
    protected double getBonificacionClima() {
        return 1.0; // mismo caso
    }

}
